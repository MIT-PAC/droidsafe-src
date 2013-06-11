package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final boolean DEBUG = false;
    protected final Context mContext;
    private boolean mFactorySet;
    private Factory mFactory;
    private Factory2 mFactory2;
    private Factory2 mPrivateFactory;
    private Filter mFilter;
    final Object[] mConstructorArgs = new Object[2];
    static final Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor<? extends View>> sConstructorMap =
            new HashMap<String, Constructor<? extends View>>();
    private HashMap<String, Boolean> mFilterMap;
    private static final String TAG_MERGE = "merge";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_1995 = "blink";
    private static final String TAG_REQUEST_FOCUS = "requestFocus";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "E7207BFA97B4D4DD74A98816C77C472E", hash_generated_method = "16EDA2DF24ED1A675342F15FB0109DFE")
    @DSModeled(DSC.SAFE)
    protected LayoutInflater(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "5CC0837D3FE56B24A71C58B4CCAA4F88", hash_generated_method = "7094C0A3431945386D3BAB62778D6892")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "AFFD098D4A16258CBADF0A2E61B5AB7C", hash_generated_method = "915AC053BFDCDE5D7ACF4530BF35E466")
    public static LayoutInflater from(Context context) {
        LayoutInflater LayoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (LayoutInflater == null) {
            throw new AssertionError("LayoutInflater not found.");
        }
        return LayoutInflater;
    }

    
    public abstract LayoutInflater cloneInContext(Context newContext);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "9B65AC4EA6CCDDDA341BF99C9DD2713E")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "7FDD2E2114CEC4DBC75B459E7197DB00", hash_generated_method = "BE0A4643612321BA9BD95D317FBD6404")
    @DSModeled(DSC.SAFE)
    public final Factory getFactory() {
        return (Factory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "1401AE51BF0559687CED2D99A883164D", hash_generated_method = "F2AA09EE98BA2031B50952A1F64EBB16")
    @DSModeled(DSC.SAFE)
    public final Factory2 getFactory2() {
        return (Factory2)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFactory2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "711BCDCCD1A0460B88DDB4B05554E6F0", hash_generated_method = "E44536879848E874F246115FFF6D1404")
    @DSModeled(DSC.SAFE)
    public void setFactory(Factory factory) {
        dsTaint.addTaint(factory.dsTaint);
        {
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } //End block
        {
            throw new NullPointerException("Given factory can not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.388 -0400", hash_original_method = "206E93CE21BFEFA64CD336FC01E3DC86", hash_generated_method = "CA4D0A1393A0211ADAEA6D0F6F63A472")
    @DSModeled(DSC.SAFE)
    public void setFactory2(Factory2 factory) {
        dsTaint.addTaint(factory.dsTaint);
        {
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } //End block
        {
            throw new NullPointerException("Given factory can not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "140FDA0509CDD22FFA77677DC0A919DF", hash_generated_method = "AC871A7DB0FCEA913CEDA586E142A1F4")
    @DSModeled(DSC.SAFE)
    public void setPrivateFactory(Factory2 factory) {
        dsTaint.addTaint(factory.dsTaint);
        // ---------- Original Method ----------
        //mPrivateFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "729FC45F62643DE6BA14E2267143ADEC")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "E7980136733C7B2EC13AC2733EC56104", hash_generated_method = "4879A99CC615B77AACE74A6105AC2D0F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "33D0E6277D03283945C33D82FE1E07F8", hash_generated_method = "7D48AE6784EBB9F3C91B95C1CCAA3DAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(int resource, ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(resource);
        View var031DD9EF175B5FBA685075E8A859A337_899891851 = (inflate(resource, root, root != null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "2C6130928BF5FC4257D730B98F9E332E", hash_generated_method = "353089449FB15FBB2905D73215CF52A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(XmlPullParser parser, ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        View var96E73414297E9D05887A7B86A6E5B7D6_660647337 = (inflate(parser, root, root != null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.389 -0400", hash_original_method = "73105F6C94DACD9E83BB5CE96738BE14", hash_generated_method = "D9ECE8A00DF0526419E152B3DEB6E9C3")
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
            View varD69941774B3894F6A25C989046D90FE4_274805336 = (inflate(parser, root, attachToRoot));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.390 -0400", hash_original_method = "9DFC9AE5F080C22C20FBC66EE3D8715B", hash_generated_method = "F7B7AA4CA6EEBE6AF356907F69146D14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        dsTaint.addTaint(attachToRoot);
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        {
            final AttributeSet attrs;
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
                    boolean varE58D9BEEA9A8E881BB4855D510C76E16_2000622463 = ((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT);
                } //End collapsed parenthetic
                {
                    throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                } //End block
                final String name;
                name = parser.getName();
                {
                    System.out.println("**************************");
                    System.out.println("Creating root view: "
                            + name);
                    System.out.println("**************************");
                } //End block
                {
                    boolean varFDE52F8163E69EE326159C2642CAEC68_534663846 = (TAG_MERGE.equals(name));
                    {
                        {
                            throw new InflateException("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                        } //End block
                        rInflate(parser, root, attrs, false);
                    } //End block
                    {
                        View temp;
                        {
                            boolean varCE5DAB92F3FE827A985DB892C11A30CF_509973237 = (TAG_1995.equals(name));
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
                throw ex;
            } //End block
            catch (IOException e)
            {
                InflateException ex;
                ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                throw ex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.390 -0400", hash_original_method = "9249249C6DEB7757C8882D406CD78B4B", hash_generated_method = "7017B381EA81C77FE23159A89F7ADC34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(prefix);
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
                        boolean var5283AA69DC1B5B630A4798CB7C4AEC9B_6631549 = (allowedState.equals(Boolean.FALSE));
                        {
                            failNotAllowed(name, prefix, attrs);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            Object[] args;
            args = mConstructorArgs;
            args[1] = attrs;
            View var3AADAD795C0FFD215CCBF77CF2F3781E_806703155 = (constructor.newInstance(args));
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            throw ie;
        } //End block
        catch (ClassCastException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Class is not a View "
                    + (prefix != null ? (prefix + name) : name));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            throw ie;
        } //End block
        catch (ClassNotFoundException e)
        {
            throw e;
        } //End block
        catch (Exception e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (clazz == null ? "<unknown>" : clazz.getName()));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            throw ie;
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.390 -0400", hash_original_method = "0971FA0124FB7B31B88F61FC842AABEB", hash_generated_method = "EB320E5E5E855A5760C677C24D27E9D1")
    @DSModeled(DSC.SAFE)
    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(prefix);
        throw new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
        // ---------- Original Method ----------
        //throw new InflateException(attrs.getPositionDescription()
                //+ ": Class not allowed to be inflated "
                //+ (prefix != null ? (prefix + name) : name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.391 -0400", hash_original_method = "9A9783E7AF685525083052EAFC6937D8", hash_generated_method = "6CAB495B4C6FB018D03BC983B5C66E40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        View varFF76487078F55A1F4C278C8F9F8A045A_669209948 = (createView(name, "android.view.", attrs));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createView(name, "android.view.", attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.391 -0400", hash_original_method = "EEF2BD4B979EFD4F0FBDCDB52C08D7B2", hash_generated_method = "44FCCBF9B3354C286D8D406916CC66A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        View var97045F7CDF43D8E6590A9852A43DC73F_314014024 = (onCreateView(name, attrs));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return onCreateView(name, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.391 -0400", hash_original_method = "42E00CE52BE01D0BF7040FF60139A865", hash_generated_method = "CC894F3EA746E73A1FB57957AF5FEDC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View createViewFromTag(View parent, String name, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean var8FFDB426A97735EAEA80E33D0B5E59B2_1420993654 = (name.equals("view"));
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
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1797530465 = (-1 == name.indexOf('.'));
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
            throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            throw ie;
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.392 -0400", hash_original_method = "3A61628D6ED69C72EF61CAE501BAE992", hash_generated_method = "3628D32E5B089BD216439BF42C9A0478")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rInflate(XmlPullParser parser, View parent, final AttributeSet attrs,
            boolean finishInflate) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(finishInflate);
        dsTaint.addTaint(parser.dsTaint);
        final int depth;
        depth = parser.getDepth();
        int type;
        {
            boolean var823E94E9B6300A88398882F66A824AFC_882853269 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT);
            {
                final String name;
                name = parser.getName();
                {
                    boolean var9E864073812E74645886E00F3C1FA42E_124730125 = (TAG_REQUEST_FOCUS.equals(name));
                    {
                        parseRequestFocus(parser, parent);
                    } //End block
                    {
                        boolean var3A72FDB7DEFA1B4376ED852227EE7220_954434389 = (TAG_INCLUDE.equals(name));
                        {
                            {
                                boolean varF9E7792F5EE78FD8E2EF7727515E4EC9_565668925 = (parser.getDepth() == 0);
                                {
                                    throw new InflateException("<include /> cannot be the root element");
                                } //End block
                            } //End collapsed parenthetic
                            parseInclude(parser, parent, attrs);
                        } //End block
                        {
                            boolean var6E0AFF7B2B3D2BD63E19797766EAC38B_1971970557 = (TAG_MERGE.equals(name));
                            {
                                throw new InflateException("<merge /> must be the root element");
                            } //End block
                            {
                                boolean varA10A7F5947ED2B40D379831A43F34249_449222638 = (TAG_1995.equals(name));
                                {
                                    final View view;
                                    view = new BlinkLayout(mContext, attrs);
                                    final ViewGroup viewGroup;
                                    viewGroup = (ViewGroup) parent;
                                    final ViewGroup.LayoutParams params;
                                    params = viewGroup.generateLayoutParams(attrs);
                                    rInflate(parser, view, attrs, true);
                                    viewGroup.addView(view, params);
                                } //End block
                                {
                                    final View view;
                                    view = createViewFromTag(parent, name, attrs);
                                    final ViewGroup viewGroup;
                                    viewGroup = (ViewGroup) parent;
                                    final ViewGroup.LayoutParams params;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.392 -0400", hash_original_method = "D305B9D132FFD898328C34D4AEEA8981", hash_generated_method = "42D3B9A29510BB10F1B51E8D90F32E19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseRequestFocus(XmlPullParser parser, View parent) throws XmlPullParserException, IOException {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        parent.requestFocus();
        final int currentDepth;
        currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_1820855420 = (((type = parser.next()) != XmlPullParser.END_TAG ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.392 -0400", hash_original_method = "3903965D4D2522F244AF5345C6CDB188", hash_generated_method = "55FB9EEA3FD1C8FBC2C3C99850384BC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseInclude(XmlPullParser parser, View parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int type;
        {
            final int layout;
            layout = attrs.getAttributeResourceValue(null, "layout", 0);
            {
                final String value;
                value = attrs.getAttributeValue(null, "layout");
                {
                    throw new InflateException("You must specifiy a layout in the"
                            + " include tag: <include layout=\"@layout/layoutID\" />");
                } //End block
                {
                    throw new InflateException("You must specifiy a valid layout "
                            + "reference. The layout ID " + value + " is not valid.");
                } //End block
            } //End block
            {
                final XmlResourceParser childParser;
                childParser = getContext().getResources().getLayout(layout);
                try 
                {
                    final AttributeSet childAttrs;
                    childAttrs = Xml.asAttributeSet(childParser);
                    {
                        boolean var85BD6F6EF64876B51C9884A0DAC7FEDE_1995820943 = ((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT);
                    } //End collapsed parenthetic
                    {
                        throw new InflateException(childParser.getPositionDescription() +
                                ": No start tag found!");
                    } //End block
                    final String childName;
                    childName = childParser.getName();
                    {
                        boolean var5E823F928FF3B68CA0565BBB723D4C0E_957991271 = (TAG_MERGE.equals(childName));
                        {
                            rInflate(childParser, parent, childAttrs, false);
                        } //End block
                        {
                            final View view;
                            view = createViewFromTag(parent, childName, childAttrs);
                            final ViewGroup group;
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
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        } //End block
        final int currentDepth;
        currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_1802854325 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FactoryMerger implements Factory2 {
        private final Factory mF1, mF2;
        private final Factory2 mF12, mF22;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "E5AD3FF1F375743BB365B35578675E98", hash_generated_method = "DF48376E8072EB841209F266DBF5628F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "912C6EE593A6921C8E87D5E0641D7CDD", hash_generated_method = "62789B8C09DABB73F22CFA98581D1927")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            View v;
            v = mF1.onCreateView(name, context, attrs);
            View var5959722AC6DFFDED21A9E586BB57038F_226601437 = (mF2.onCreateView(name, context, attrs));
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View v = mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF2.onCreateView(name, context, attrs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "F1957EAE5145EA0F0129265F270794D6", hash_generated_method = "29E2EF6111CA7ACF9FE17F81A3DC8084")
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
                Object varA83A43314A20D846C5B68D12F0F078EF_68156291 = (mF22.onCreateView(parent, name, context, attrs));
                Object varD22BC25580B45E8C0E4F1FA3D5D3D749_1844969873 = (mF2.onCreateView(name, context, attrs));
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
        private static final int MESSAGE_BLINK = 0x42;
        private static final int BLINK_DELAY = 500;
        private boolean mBlink;
        private boolean mBlinkState;
        private final Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "3DD68C66D41BE889B84232F33376A99A", hash_generated_method = "115D8D8030254DF9128EEC112D9955AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BlinkLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            mHandler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == MESSAGE_BLINK) {
                        if (mBlink) {
                            mBlinkState = !mBlinkState;
                            makeBlink();
                        }
                        invalidate();
                        return true;
                    }
                    return false;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "553FA2CA85816FF11073226F48838667", hash_generated_method = "C1820A04A080813ED9D051384B2AE162")
        @DSModeled(DSC.SAFE)
        private void makeBlink() {
            Message message;
            message = mHandler.obtainMessage(MESSAGE_BLINK);
            mHandler.sendMessageDelayed(message, BLINK_DELAY);
            // ---------- Original Method ----------
            //Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            //mHandler.sendMessageDelayed(message, BLINK_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.393 -0400", hash_original_method = "F84801EA6DE017B4DF3D928CA8059755", hash_generated_method = "08D685710AB70A59F4EC50A6D94CB26C")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.394 -0400", hash_original_method = "68779D94DBD6ED32D8C444331B18EB29", hash_generated_method = "DEDA9171770C751179F371ACF37FC800")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.394 -0400", hash_original_method = "B2A7E99D93A7E570FADBB759CB038122", hash_generated_method = "57A9B511EA2158D211E3AA16CCA9A92C")
        @DSModeled(DSC.SAFE)
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
    
}


