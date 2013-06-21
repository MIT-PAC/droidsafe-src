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
    private boolean DEBUG = false;
    protected Context mContext;
    private boolean mFactorySet;
    private Factory mFactory;
    private Factory2 mFactory2;
    private Factory2 mPrivateFactory;
    private Filter mFilter;
    Object[] mConstructorArgs = new Object[2];
    private HashMap<String, Boolean> mFilterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.068 -0400", hash_original_method = "E7207BFA97B4D4DD74A98816C77C472E", hash_generated_method = "921C22CB64992F8B67F5C8096C15EC5D")
    @DSModeled(DSC.SAFE)
    protected LayoutInflater(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.068 -0400", hash_original_method = "5CC0837D3FE56B24A71C58B4CCAA4F88", hash_generated_method = "7953F71118A4F91EF9360CB0683B059C")
    @DSModeled(DSC.SAFE)
    protected LayoutInflater(LayoutInflater original, Context newContext) {
        dsTaint.addTaint(newContext.dsTaint);
        dsTaint.addTaint(original.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.068 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.068 -0400", hash_original_method = "7FDD2E2114CEC4DBC75B459E7197DB00", hash_generated_method = "43110B80E187A217A198D972562771F7")
    @DSModeled(DSC.SAFE)
    public final Factory getFactory() {
        return (Factory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.068 -0400", hash_original_method = "1401AE51BF0559687CED2D99A883164D", hash_generated_method = "CDD4868CB22B9CD575DEAE90F1ADB83E")
    @DSModeled(DSC.SAFE)
    public final Factory2 getFactory2() {
        return (Factory2)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFactory2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.069 -0400", hash_original_method = "711BCDCCD1A0460B88DDB4B05554E6F0", hash_generated_method = "85A181E68CD62E2F4386871F73194378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFactory(Factory factory) {
        dsTaint.addTaint(factory.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } //End block
        mFactorySet = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.069 -0400", hash_original_method = "206E93CE21BFEFA64CD336FC01E3DC86", hash_generated_method = "A042DBF896D6F28264B5F74C087696AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFactory2(Factory2 factory) {
        dsTaint.addTaint(factory.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.069 -0400", hash_original_method = "140FDA0509CDD22FFA77677DC0A919DF", hash_generated_method = "2EC1F5634B528B46EACA4FE7DB9E8516")
    @DSModeled(DSC.SAFE)
    public void setPrivateFactory(Factory2 factory) {
        dsTaint.addTaint(factory.dsTaint);
        // ---------- Original Method ----------
        //mPrivateFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.069 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "D1E79F7121286E828DE269A5F3FE8A29")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.070 -0400", hash_original_method = "E7980136733C7B2EC13AC2733EC56104", hash_generated_method = "D09E3D01C2ECFC45DC67531BE704424C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilter(Filter filter) {
        dsTaint.addTaint(filter.dsTaint);
        {
            mFilterMap = new HashMap<String, Boolean>();
        } //End block
        // ---------- Original Method ----------
        //mFilter = filter;
        //if (filter != null) {
            //mFilterMap = new HashMap<String, Boolean>();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.070 -0400", hash_original_method = "33D0E6277D03283945C33D82FE1E07F8", hash_generated_method = "1FA265EA9DBDA33A695F6F5EFB73EB05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(int resource, ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(resource);
        View var031DD9EF175B5FBA685075E8A859A337_41089674 = (inflate(resource, root, root != null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.070 -0400", hash_original_method = "2C6130928BF5FC4257D730B98F9E332E", hash_generated_method = "ED58CB9CC5230A0780999D036731368C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(XmlPullParser parser, ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        View var96E73414297E9D05887A7B86A6E5B7D6_871282129 = (inflate(parser, root, root != null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.070 -0400", hash_original_method = "73105F6C94DACD9E83BB5CE96738BE14", hash_generated_method = "782AC9785F20C189818E1FFE63DC2317")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        dsTaint.addTaint(attachToRoot);
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(resource);
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser;
        parser = getContext().getResources().getLayout(resource);
        try 
        {
            View varD69941774B3894F6A25C989046D90FE4_350997886 = (inflate(parser, root, attachToRoot));
        } //End block
        finally 
        {
            parser.close();
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getLayout(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.071 -0400", hash_original_method = "9DFC9AE5F080C22C20FBC66EE3D8715B", hash_generated_method = "C58A7B6C569C435DAF58368300D6ACF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        dsTaint.addTaint(attachToRoot);
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
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
                    boolean varE58D9BEEA9A8E881BB4855D510C76E16_1474060161 = ((type = parser.next()) != XmlPullParser.START_TAG &&
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
                    boolean varFDE52F8163E69EE326159C2642CAEC68_619156040 = (TAG_MERGE.equals(name));
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
                            boolean varCE5DAB92F3FE827A985DB892C11A30CF_777195582 = (TAG_1995.equals(name));
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
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.072 -0400", hash_original_method = "9249249C6DEB7757C8882D406CD78B4B", hash_generated_method = "D630EED03AA533432E0354DF9D6A6A46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(name);
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
                        boolean var5283AA69DC1B5B630A4798CB7C4AEC9B_18831877 = (allowedState.equals(Boolean.FALSE));
                        {
                            failNotAllowed(name, prefix, attrs);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            Object[] args;
            args = mConstructorArgs;
            args[1] = attrs;
            View var3AADAD795C0FFD215CCBF77CF2F3781E_1250422550 = (constructor.newInstance(args));
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
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.072 -0400", hash_original_method = "0971FA0124FB7B31B88F61FC842AABEB", hash_generated_method = "12DA78EA842D929B2553EF63B4EB6B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(name);
        if (DroidSafeAndroidRuntime.control) throw new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
        // ---------- Original Method ----------
        //throw new InflateException(attrs.getPositionDescription()
                //+ ": Class not allowed to be inflated "
                //+ (prefix != null ? (prefix + name) : name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.072 -0400", hash_original_method = "9A9783E7AF685525083052EAFC6937D8", hash_generated_method = "C3EE3832AF52D3EC68A45B4BC30A67B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        View varFF76487078F55A1F4C278C8F9F8A045A_735218931 = (createView(name, "android.view.", attrs));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createView(name, "android.view.", attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.073 -0400", hash_original_method = "EEF2BD4B979EFD4F0FBDCDB52C08D7B2", hash_generated_method = "F8002FD32BE38B9D2EA37C89530C6807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        View var97045F7CDF43D8E6590A9852A43DC73F_1419271290 = (onCreateView(name, attrs));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return onCreateView(name, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.073 -0400", hash_original_method = "42E00CE52BE01D0BF7040FF60139A865", hash_generated_method = "D319995CAEEE7687E2B29EDCD2D56DDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View createViewFromTag(View parent, String name, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean var8FFDB426A97735EAEA80E33D0B5E59B2_279841764 = (name.equals("view"));
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
                    boolean var8670E3C6635B63F51E108DA3DA62F822_572206039 = (-1 == name.indexOf('.'));
                    {
                        view = onCreateView(parent, name, attrs);
                    } //End block
                    {
                        view = createView(name, null, attrs);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            System.out.println("Created view is: " + view);
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
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.074 -0400", hash_original_method = "3A61628D6ED69C72EF61CAE501BAE992", hash_generated_method = "574456F6E8F4738E01F61B39CF3502AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rInflate(XmlPullParser parser, View parent, final AttributeSet attrs,
            boolean finishInflate) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(finishInflate);
        dsTaint.addTaint(parser.dsTaint);
        int depth;
        depth = parser.getDepth();
        int type;
        {
            boolean var823E94E9B6300A88398882F66A824AFC_646646473 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT);
            {
                String name;
                name = parser.getName();
                {
                    boolean var9E864073812E74645886E00F3C1FA42E_1103552522 = (TAG_REQUEST_FOCUS.equals(name));
                    {
                        parseRequestFocus(parser, parent);
                    } //End block
                    {
                        boolean var3A72FDB7DEFA1B4376ED852227EE7220_1163441711 = (TAG_INCLUDE.equals(name));
                        {
                            {
                                boolean varF9E7792F5EE78FD8E2EF7727515E4EC9_703573781 = (parser.getDepth() == 0);
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new InflateException("<include /> cannot be the root element");
                                } //End block
                            } //End collapsed parenthetic
                            parseInclude(parser, parent, attrs);
                        } //End block
                        {
                            boolean var6E0AFF7B2B3D2BD63E19797766EAC38B_1735480665 = (TAG_MERGE.equals(name));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new InflateException("<merge /> must be the root element");
                            } //End block
                            {
                                boolean varA10A7F5947ED2B40D379831A43F34249_1741005996 = (TAG_1995.equals(name));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.074 -0400", hash_original_method = "D305B9D132FFD898328C34D4AEEA8981", hash_generated_method = "DF03897ECC53A004A3C6A32E1B5DED92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseRequestFocus(XmlPullParser parser, View parent) throws XmlPullParserException, IOException {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        parent.requestFocus();
        int currentDepth;
        currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_210486556 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int type;
        //parent.requestFocus();
        //final int currentDepth = parser.getDepth();
        //while (((type = parser.next()) != XmlPullParser.END_TAG ||
                //parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.075 -0400", hash_original_method = "3903965D4D2522F244AF5345C6CDB188", hash_generated_method = "63C20CB4D65AD518F92016FE3631B07D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseInclude(XmlPullParser parser, View parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
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
                        boolean var85BD6F6EF64876B51C9884A0DAC7FEDE_667714299 = ((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InflateException(childParser.getPositionDescription() +
                                ": No start tag found!");
                    } //End block
                    String childName;
                    childName = childParser.getName();
                    {
                        boolean var5E823F928FF3B68CA0565BBB723D4C0E_823505254 = (TAG_MERGE.equals(childName));
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
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_1829485181 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FactoryMerger implements Factory2 {
        private Factory mF1, mF2;
        private Factory2 mF12, mF22;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.075 -0400", hash_original_method = "E5AD3FF1F375743BB365B35578675E98", hash_generated_method = "67D4A49541C85606EAA40C531C4153D4")
        @DSModeled(DSC.SAFE)
         FactoryMerger(Factory f1, Factory2 f12, Factory f2, Factory2 f22) {
            dsTaint.addTaint(f12.dsTaint);
            dsTaint.addTaint(f22.dsTaint);
            dsTaint.addTaint(f1.dsTaint);
            dsTaint.addTaint(f2.dsTaint);
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
            //mF12 = f12;
            //mF22 = f22;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.076 -0400", hash_original_method = "912C6EE593A6921C8E87D5E0641D7CDD", hash_generated_method = "D3F44CF6D2B3E293483C151D94ED8275")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            View v;
            v = mF1.onCreateView(name, context, attrs);
            View var5959722AC6DFFDED21A9E586BB57038F_1324079454 = (mF2.onCreateView(name, context, attrs));
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View v = mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF2.onCreateView(name, context, attrs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.076 -0400", hash_original_method = "F1957EAE5145EA0F0129265F270794D6", hash_generated_method = "A43CE1BC68E0E5A04D7213AABDACEAF1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(parent.dsTaint);
            View v;
            v = mF12.onCreateView(parent, name, context, attrs);
            v = mF1.onCreateView(name, context, attrs);
            {
                Object varA83A43314A20D846C5B68D12F0F078EF_1282465821 = (mF22.onCreateView(parent, name, context, attrs));
                Object varD22BC25580B45E8C0E4F1FA3D5D3D749_1598157180 = (mF2.onCreateView(name, context, attrs));
            } //End flattened ternary
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View v = mF12 != null ? mF12.onCreateView(parent, name, context, attrs)
                    //: mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    //: mF2.onCreateView(name, context, attrs);
        }

        
    }


    
    private static class BlinkLayout extends FrameLayout {
        private boolean mBlink;
        private boolean mBlinkState;
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.077 -0400", hash_original_method = "3DD68C66D41BE889B84232F33376A99A", hash_generated_method = "B9BFD7FE60D37C1ADB1E9250E4BEFB5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BlinkLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            mHandler = new Handler(new Handler.Callback() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.077 -0400", hash_original_method = "3CDE63BB1E6E2FE4ACBB53B93DE4CB6C", hash_generated_method = "2BFB0C0715870DDA28D1DA8342B3EE7E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    {
                        {
                            mBlinkState = !mBlinkState;
                            makeBlink();
                        } //End block
                        invalidate();
                    } //End block
                    return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.077 -0400", hash_original_method = "553FA2CA85816FF11073226F48838667", hash_generated_method = "270C074C6E7784515BFD5F9497C40081")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void makeBlink() {
            Message message;
            message = mHandler.obtainMessage(MESSAGE_BLINK);
            mHandler.sendMessageDelayed(message, BLINK_DELAY);
            // ---------- Original Method ----------
            //Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            //mHandler.sendMessageDelayed(message, BLINK_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.078 -0400", hash_original_method = "F84801EA6DE017B4DF3D928CA8059755", hash_generated_method = "5442A9264ED4F4E31C0BA66C5931886A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.078 -0400", hash_original_method = "68779D94DBD6ED32D8C444331B18EB29", hash_generated_method = "A65982EADCE2056B98837C8AE9E7BCE2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.078 -0400", hash_original_method = "B2A7E99D93A7E570FADBB759CB038122", hash_generated_method = "52E893B41BD55D5FA83D18F91D6EE682")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void dispatchDraw(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            {
                super.dispatchDraw(canvas);
            } //End block
            // ---------- Original Method ----------
            //if (mBlinkState) {
                //super.dispatchDraw(canvas);
            //}
        }

        
        private static final int MESSAGE_BLINK = 0x42;
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
    
    static final Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor<? extends View>> sConstructorMap =
            new HashMap<String, Constructor<? extends View>>();
    private static final String TAG_MERGE = "merge";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_1995 = "blink";
    private static final String TAG_REQUEST_FOCUS = "requestFocus";
}

