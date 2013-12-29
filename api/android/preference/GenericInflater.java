package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;





abstract class GenericInflater<T, P extends GenericInflater.Parent> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.773 -0500", hash_original_field = "C2CE271B9176DC90609E3CB2F2410951", hash_generated_field = "DA025B3CEA9F6DF229E9360E35C80379")


    private static final Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.774 -0500", hash_original_field = "1D2BE8CD178DF0B2A55E88131CB5C0BD", hash_generated_field = "61C67D80619B2C9C71EFD304BA972A02")


    private static final HashMap sConstructorMap = new HashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.769 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "40AF400BA8F86FA9C9E428F903D03FF5")

    private final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.770 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")


    protected  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.770 -0500", hash_original_field = "ABBF88F2FF66E1F410D2E6FD81CC8AE8", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.771 -0500", hash_original_field = "988EAECE93375894F84ACA295DACF671", hash_generated_field = "05BA2F2FD6F3066B67DC96510DE31D25")

    private Factory<T> mFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.772 -0500", hash_original_field = "D62709ECD69C2FFB452C5E25B014B17D", hash_generated_field = "BAC245513231B6A4CDBDF61862A69933")


    private final Object[] mConstructorArgs = new Object[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.775 -0500", hash_original_field = "519963041C1A7EDF0E04C4D6835A8254", hash_generated_field = "6581AC575AE1E4EEB60567A9B3808F54")


    private String mDefaultPackage;
    
    /**
     * Create a new inflater instance associated with a
     * particular Context.
     * 
     * @param context The Context in which this inflater will
     *            create its items; most importantly, this supplies the theme
     *            from which the default values for their attributes are
     *            retrieved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.781 -0500", hash_original_method = "A8AA332702376B454A767A9414B9F159", hash_generated_method = "9A2F3CF5820C68497CED7FBB8AAEA693")
    protected GenericInflater(Context context) {
        mContext = context;
    }

    /**
     * Create a new inflater instance that is a copy of an
     * existing inflater, optionally with its Context
     * changed. For use in implementing {@link #cloneInContext}.
     * 
     * @param original The original inflater to copy.
     * @param newContext The new Context to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.782 -0500", hash_original_method = "6B35BDBE0F984168A951D53A5AF8F867", hash_generated_method = "B6C272B8068BA07B001D799AFFEB1FE6")
    protected GenericInflater(GenericInflater<T,P> original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
    }
    
    /**
     * Create a copy of the existing inflater object, with the copy
     * pointing to a different Context than the original.  This is used by
     * {@link ContextThemeWrapper} to create a new inflater to go along
     * with the new Context theme.
     * 
     * @param newContext The new Context to associate with the new inflater.
     * May be the same as the original Context if desired.
     * 
     * @return Returns a brand spanking new inflater object associated with
     * the given Context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.783 -0500", hash_original_method = "47E20DE42F11CCA85C2DA73EB641838F", hash_generated_method = "B52D5F76A890DD7905617D959FF36D62")
    public abstract GenericInflater cloneInContext(Context newContext);
    
    /**
     * Sets the default package that will be searched for classes to construct
     * for tag names that have no explicit package.
     * 
     * @param defaultPackage The default package. This will be prepended to the
     *            tag name, so it should end with a period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.784 -0500", hash_original_method = "601AA595429A3B000CED526A81A8472C", hash_generated_method = "646B10157093FC7B99A3929DF75DAAEF")
    public void setDefaultPackage(String defaultPackage) {
        mDefaultPackage = defaultPackage;
    }
    
    /**
     * Returns the default package, or null if it is not set.
     * 
     * @see #setDefaultPackage(String)
     * @return The default package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.784 -0500", hash_original_method = "46E608B0485504B383BE067A0BD6622F", hash_generated_method = "112D4FD4D5CFE92EC720DB3E3063547B")
    public String getDefaultPackage() {
        return mDefaultPackage;
    }
    
    /**
     * Return the context we are running in, for access to resources, class
     * loader, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.786 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    public Context getContext() {
        return mContext;
    }

    /**
     * Return the current factory (or null). This is called on each element
     * name. If the factory returns an item, add that to the hierarchy. If it
     * returns null, proceed to call onCreateItem(name).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.787 -0500", hash_original_method = "E145074F4BEE68EC84A4CE1558E8DDDD", hash_generated_method = "0703CBAE1D3C3CF6753E625BE1DA0EDF")
    public final Factory<T> getFactory() {
        return mFactory;
    }

    /**
     * Attach a custom Factory interface for creating items while using this
     * inflater. This must not be null, and can only be set
     * once; after setting, you can not change the factory. This is called on
     * each element name as the XML is parsed. If the factory returns an item,
     * that is added to the hierarchy. If it returns null, the next factory
     * default {@link #onCreateItem} method is called.
     * <p>
     * If you have an existing inflater and want to add your
     * own factory to it, use {@link #cloneInContext} to clone the existing
     * instance and then you can use this function (once) on the returned new
     * instance. This will merge your own factory with whatever factory the
     * original instance is using.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.787 -0500", hash_original_method = "F731ABA6658EE884292BF19729B20DA7", hash_generated_method = "2B83A4FABC6F58CE746212AB37CCB94F")
    public void setFactory(Factory<T> factory) {
        if (mFactorySet) {
            throw new IllegalStateException("" +
            		"A factory has already been set on this inflater");
        }
        if (factory == null) {
            throw new NullPointerException("Given factory can not be null");
        }
        mFactorySet = true;
        if (mFactory == null) {
            mFactory = factory;
        } else {
            mFactory = new FactoryMerger<T>(factory, mFactory);
        }
    }


    /**
     * Inflate a new item hierarchy from the specified xml resource. Throws
     * InflaterException if there is an error.
     * 
     * @param resource ID for an XML resource to load (e.g.,
     *        <code>R.layout.main_page</code>)
     * @param root Optional parent of the generated hierarchy.
     * @return The root of the inflated hierarchy. If root was supplied,
     *         this is the root item; otherwise it is the root of the inflated
     *         XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.788 -0500", hash_original_method = "0AF1546F925E79A6FCD8229E5389F782", hash_generated_method = "15515F3777F9EC741F476FAB1AD3BB28")
    public T inflate(int resource, P root) {
        return inflate(resource, root, root != null);
    }

    /**
     * Inflate a new hierarchy from the specified xml node. Throws
     * InflaterException if there is an error. *
     * <p>
     * <em><strong>Important</strong></em>&nbsp;&nbsp;&nbsp;For performance
     * reasons, inflation relies heavily on pre-processing of XML files
     * that is done at build time. Therefore, it is not currently possible to
     * use inflater with an XmlPullParser over a plain XML file at runtime.
     * 
     * @param parser XML dom node containing the description of the
     *        hierarchy.
     * @param root Optional parent of the generated hierarchy.
     * @return The root of the inflated hierarchy. If root was supplied,
     *         this is the that; otherwise it is the root of the inflated
     *         XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.789 -0500", hash_original_method = "A09A6320AB1158C141A52528AA964FE1", hash_generated_method = "617544E019A0A5B53870777F1F7A1F55")
    public T inflate(XmlPullParser parser, P root) {
        return inflate(parser, root, root != null);
    }

    /**
     * Inflate a new hierarchy from the specified xml resource. Throws
     * InflaterException if there is an error.
     * 
     * @param resource ID for an XML resource to load (e.g.,
     *        <code>R.layout.main_page</code>)
     * @param root Optional root to be the parent of the generated hierarchy (if
     *        <em>attachToRoot</em> is true), or else simply an object that
     *        provides a set of values for root of the returned
     *        hierarchy (if <em>attachToRoot</em> is false.)
     * @param attachToRoot Whether the inflated hierarchy should be attached to
     *        the root parameter?
     * @return The root of the inflated hierarchy. If root was supplied and
     *         attachToRoot is true, this is root; otherwise it is the root of
     *         the inflated XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.790 -0500", hash_original_method = "C3BB64443334F9B40F1AFC79B102744E", hash_generated_method = "C5499E0AD6467CFE288F1645338F151B")
    public T inflate(int resource, P root, boolean attachToRoot) {
        if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getXml(resource);
        try {
            return inflate(parser, root, attachToRoot);
        } finally {
            parser.close();
        }
    }

    /**
     * Inflate a new hierarchy from the specified XML node. Throws
     * InflaterException if there is an error.
     * <p>
     * <em><strong>Important</strong></em>&nbsp;&nbsp;&nbsp;For performance
     * reasons, inflation relies heavily on pre-processing of XML files
     * that is done at build time. Therefore, it is not currently possible to
     * use inflater with an XmlPullParser over a plain XML file at runtime.
     * 
     * @param parser XML dom node containing the description of the
     *        hierarchy.
     * @param root Optional to be the parent of the generated hierarchy (if
     *        <em>attachToRoot</em> is true), or else simply an object that
     *        provides a set of values for root of the returned
     *        hierarchy (if <em>attachToRoot</em> is false.)
     * @param attachToRoot Whether the inflated hierarchy should be attached to
     *        the root parameter?
     * @return The root of the inflated hierarchy. If root was supplied and
     *         attachToRoot is true, this is root; otherwise it is the root of
     *         the inflated XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.791 -0500", hash_original_method = "93981E75696898B46E3B07FB71CA5701", hash_generated_method = "F7CBDD8E68F702CE7763BE8921E5FBC3")
    public T inflate(XmlPullParser parser, P root,
            boolean attachToRoot) {
        synchronized (mConstructorArgs) {
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            mConstructorArgs[0] = mContext;
            T result = (T) root;

            try {
                // Look for the root node.
                int type;
                while ((type = parser.next()) != parser.START_TAG
                        && type != parser.END_DOCUMENT) {
                    ;
                }

                if (type != parser.START_TAG) {
                    throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                }

                if (DEBUG) {
                    System.out.println("**************************");
                    System.out.println("Creating root: "
                            + parser.getName());
                    System.out.println("**************************");
                }
                // Temp is the root that was found in the xml
                T xmlRoot = createItemFromTag(parser, parser.getName(),
                        attrs);

                result = (T) onMergeRoots(root, attachToRoot, (P) xmlRoot);
                
                if (DEBUG) {
                    System.out.println("-----> start inflating children");
                }
                // Inflate all children under temp
                rInflate(parser, result, attrs);
                if (DEBUG) {
                    System.out.println("-----> done inflating children");
                }

            } catch (InflateException e) {
                throw e;

            } catch (XmlPullParserException e) {
                InflateException ex = new InflateException(e.getMessage());
                ex.initCause(e);
                throw ex;
            } catch (IOException e) {
                InflateException ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                throw ex;
            }

            return result;
        }
    }

    /**
     * Low-level function for instantiating by name. This attempts to
     * instantiate class of the given <var>name</var> found in this
     * inflater's ClassLoader.
     * 
     * <p>
     * There are two things that can happen in an error case: either the
     * exception describing the error will be thrown, or a null will be
     * returned. You must deal with both possibilities -- the former will happen
     * the first time createItem() is called for a class of a particular name,
     * the latter every time there-after for that class name.
     * 
     * @param name The full name of the class to be instantiated.
     * @param attrs The XML attributes supplied for this instance.
     * 
     * @return The newly instantied item, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.792 -0500", hash_original_method = "AB0D32CECCD43C7D0F0360210FD11363", hash_generated_method = "7919B56F6EAD7F837ED945AED21B5B41")
    public final T createItem(String name, String prefix, AttributeSet attrs)
            throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) sConstructorMap.get(name);

        try {
            if (null == constructor) {
                // Class not found in the cache, see if it's real,
                // and try to add it
                Class clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            }

            Object[] args = mConstructorArgs;
            args[1] = attrs;
            return (T) constructor.newInstance(args);

        } catch (NoSuchMethodException e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            throw ie;

        } catch (ClassNotFoundException e) {
            // If loadClass fails, we should propagate the exception.
            throw e;
        } catch (Exception e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + constructor.getClass().getName());
            ie.initCause(e);
            throw ie;
        }
    }

    /**
     * This routine is responsible for creating the correct subclass of item
     * given the xml element name. Override it to handle custom item objects. If
     * you override this in your subclass be sure to call through to
     * super.onCreateItem(name) for names you do not recognize.
     * 
     * @param name The fully qualified class name of the item to be create.
     * @param attrs An AttributeSet of attributes to apply to the item.
     * @return The item created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.793 -0500", hash_original_method = "4FBBE2487A51D08C4064228D927262EC", hash_generated_method = "91547C1BBC30592555132F7586DE28F6")
    protected T onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        return createItem(name, mDefaultPackage, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.794 -0500", hash_original_method = "8A20619C5B186F5C05E29B17BC664D21", hash_generated_method = "140C39444B2C4CE8BB5503AF3B995DC2")
    private final T createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        if (DEBUG) System.out.println("******** Creating item: " + name);

        try {
            T item = (mFactory == null) ? null : mFactory.onCreateItem(name, mContext, attrs);

            if (item == null) {
                if (-1 == name.indexOf('.')) {
                    item = onCreateItem(name, attrs);
                } else {
                    item = createItem(name, null, attrs);
                }
            }

            if (DEBUG) System.out.println("Created item is: " + item);
            return item;

        } catch (InflateException e) {
            throw e;

        } catch (ClassNotFoundException e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;

        } catch (Exception e) {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;
        }
    }

    /**
     * Recursive method used to descend down the xml hierarchy and instantiate
     * items, instantiate their children, and then call onFinishInflate().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.795 -0500", hash_original_method = "DD09A710ED93B5E593984A56AAF093F3", hash_generated_method = "B1ECB8CF4BB8E553CCEA1A1F500B4A19")
    private void rInflate(XmlPullParser parser, T parent, final AttributeSet attrs)
            throws XmlPullParserException, IOException {
        final int depth = parser.getDepth();

        int type;
        while (((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT) {

            if (type != parser.START_TAG) {
                continue;
            }

            if (onCreateCustomFromTag(parser, parent, attrs)) {
                continue;
            }

            if (DEBUG) {
                System.out.println("Now inflating tag: " + parser.getName());
            }
            String name = parser.getName();

            T item = createItemFromTag(parser, name, attrs);

            if (DEBUG) {
                System.out
                        .println("Creating params from parent: " + parent);
            }

            ((P) parent).addItemFromInflater(item);

            if (DEBUG) {
                System.out.println("-----> start inflating children");
            }
            rInflate(parser, item, attrs);
            if (DEBUG) {
                System.out.println("-----> done inflating children");
            }
        }

    }

    
    private static class FactoryMerger<T> implements Factory<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.272 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "C926E99D17BAF92FDF4D7BA2DC2DD9F0")

        private Factory<T> mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.272 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "B5C59E0FE8A8E61FE994C8B9CBE70464")

        private Factory<T> mF2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.779 -0500", hash_original_method = "8268493149B8E87B72D799F680E0E2F1", hash_generated_method = "8268493149B8E87B72D799F680E0E2F1")
        FactoryMerger(Factory<T> f1, Factory<T> f2) {
            mF1 = f1;
            mF2 = f2;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.780 -0500", hash_original_method = "361561DAAA3A2CCBFCF79A32350158C1", hash_generated_method = "EAE258500A20FC86F475194AFBD4F064")
        public T onCreateItem(String name, Context context, AttributeSet attrs) {
            T v = mF1.onCreateItem(name, context, attrs);
            if (v != null) return v;
            return mF2.onCreateItem(name, context, attrs);
        }

        
    }


    
    public interface Parent<T> {
        public void addItemFromInflater(T child);
    }
    
    public interface Factory<T> {
        
        public T onCreateItem(String name, Context context, AttributeSet attrs);
    }
    
    /**
     * Before this inflater tries to create an item from the tag, this method
     * will be called. The parser will be pointing to the start of a tag, you
     * must stop parsing and return when you reach the end of this element!
     * 
     * @param parser XML dom node containing the description of the hierarchy.
     * @param parent The item that should be the parent of whatever you create.
     * @param attrs An AttributeSet of attributes to apply to the item.
     * @return Whether you created a custom object (true), or whether this
     *         inflater should proceed to create an item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.796 -0500", hash_original_method = "19860FA740DE510446609E99D1C237FB", hash_generated_method = "B0E00EAE3E94D1BF4660D3BF90B18214")
    protected boolean onCreateCustomFromTag(XmlPullParser parser, T parent,
            final AttributeSet attrs) throws XmlPullParserException {
        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.796 -0500", hash_original_method = "5E31CC12237E180F4815989ECA3F6501", hash_generated_method = "8D4D3EE01A5DCD1372CFB5C67EE2F298")
    protected P onMergeRoots(P givenRoot, boolean attachToGivenRoot, P xmlRoot) {
        return xmlRoot;
    }
}

