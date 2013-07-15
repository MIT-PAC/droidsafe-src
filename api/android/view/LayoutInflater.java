package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "40AF400BA8F86FA9C9E428F903D03FF5")

    private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "BF67D382843E913B81807CA170E68BEC")

    private Factory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "E5CABF68FB335FA237AE4D7C7F579B2E", hash_generated_field = "DDA453B5760FDE700FAD36F64FD01268")

    private Factory2 mFactory2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "69B57BE67F61B50D5B598BC00B0D995C", hash_generated_field = "91C09704D064CA0F12ECD6E6EFEC80CF")

    private Factory2 mPrivateFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "B7AB5DA0883F2685164B5F2691D42F0F")

    final Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.284 -0400", hash_original_field = "B716D3BF18675199220673D5170091C2", hash_generated_field = "208DFBA685342B06C1A3F18B71A9291E")

    private HashMap<String, Boolean> mFilterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.285 -0400", hash_original_method = "E7207BFA97B4D4DD74A98816C77C472E", hash_generated_method = "E7012C3F049DB497107558CB08563437")
    protected  LayoutInflater(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.286 -0400", hash_original_method = "5CC0837D3FE56B24A71C58B4CCAA4F88", hash_generated_method = "73B9412CB86D13A699FB0B44C161827A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.286 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "C80107CC1CFF6D19D17665D322CA3787")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_2138007396 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2138007396.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2138007396;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.286 -0400", hash_original_method = "7FDD2E2114CEC4DBC75B459E7197DB00", hash_generated_method = "A1FD669B94A5FA7A8526E66B0CF56C34")
    public final Factory getFactory() {
Factory var086273A71AC89A5E1A3A59778647C1F0_1885594354 =         mFactory;
        var086273A71AC89A5E1A3A59778647C1F0_1885594354.addTaint(taint);
        return var086273A71AC89A5E1A3A59778647C1F0_1885594354;
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.287 -0400", hash_original_method = "1401AE51BF0559687CED2D99A883164D", hash_generated_method = "67F481A19B475F9DF31CF81124538790")
    public final Factory2 getFactory2() {
Factory2 var719195FDDEF7C93B6BEED74314FE4BE8_966945199 =         mFactory2;
        var719195FDDEF7C93B6BEED74314FE4BE8_966945199.addTaint(taint);
        return var719195FDDEF7C93B6BEED74314FE4BE8_966945199;
        // ---------- Original Method ----------
        //return mFactory2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.287 -0400", hash_original_method = "711BCDCCD1A0460B88DDB4B05554E6F0", hash_generated_method = "1CAD89D4917DC32EA85F48704A3BD771")
    public void setFactory(Factory factory) {
    if(mFactorySet)        
        {
            IllegalStateException var7F3CD20B699DE21D25C99ABD1773E8E9_293893707 = new IllegalStateException("A factory has already been set on this LayoutInflater");
            var7F3CD20B699DE21D25C99ABD1773E8E9_293893707.addTaint(taint);
            throw var7F3CD20B699DE21D25C99ABD1773E8E9_293893707;
        } //End block
    if(factory == null)        
        {
            NullPointerException var4E80D5BF81BCD97DD9195749F4C7E02F_673892588 = new NullPointerException("Given factory can not be null");
            var4E80D5BF81BCD97DD9195749F4C7E02F_673892588.addTaint(taint);
            throw var4E80D5BF81BCD97DD9195749F4C7E02F_673892588;
        } //End block
        mFactorySet = true;
    if(mFactory == null)        
        {
            mFactory = factory;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.288 -0400", hash_original_method = "206E93CE21BFEFA64CD336FC01E3DC86", hash_generated_method = "76FEF9F0F9C302206A5F16BDE641B788")
    public void setFactory2(Factory2 factory) {
    if(mFactorySet)        
        {
            IllegalStateException var7F3CD20B699DE21D25C99ABD1773E8E9_761911056 = new IllegalStateException("A factory has already been set on this LayoutInflater");
            var7F3CD20B699DE21D25C99ABD1773E8E9_761911056.addTaint(taint);
            throw var7F3CD20B699DE21D25C99ABD1773E8E9_761911056;
        } //End block
    if(factory == null)        
        {
            NullPointerException var4E80D5BF81BCD97DD9195749F4C7E02F_492376047 = new NullPointerException("Given factory can not be null");
            var4E80D5BF81BCD97DD9195749F4C7E02F_492376047.addTaint(taint);
            throw var4E80D5BF81BCD97DD9195749F4C7E02F_492376047;
        } //End block
        mFactorySet = true;
    if(mFactory == null)        
        {
            mFactory = mFactory2 = factory;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.289 -0400", hash_original_method = "140FDA0509CDD22FFA77677DC0A919DF", hash_generated_method = "7B48C17DCCFC347FF964BDAD9D35BB77")
    public void setPrivateFactory(Factory2 factory) {
        mPrivateFactory = factory;
        // ---------- Original Method ----------
        //mPrivateFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.289 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "2C7CE8797E9E4FF4891CA9EEAD0284A5")
    public Filter getFilter() {
Filter var6104E4BD549FCD2640641D136DD683A6_380344631 =         mFilter;
        var6104E4BD549FCD2640641D136DD683A6_380344631.addTaint(taint);
        return var6104E4BD549FCD2640641D136DD683A6_380344631;
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.290 -0400", hash_original_method = "E7980136733C7B2EC13AC2733EC56104", hash_generated_method = "719047763D4AE2B88D457981EF08557F")
    public void setFilter(Filter filter) {
        mFilter = filter;
    if(filter != null)        
        {
            mFilterMap = new HashMap<String, Boolean>();
        } //End block
        // ---------- Original Method ----------
        //mFilter = filter;
        //if (filter != null) {
            //mFilterMap = new HashMap<String, Boolean>();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.290 -0400", hash_original_method = "33D0E6277D03283945C33D82FE1E07F8", hash_generated_method = "DBF31700AE1DCA625A1F1D55ED99449C")
    public View inflate(int resource, ViewGroup root) {
        addTaint(root.getTaint());
        addTaint(resource);
View varF5D4BA408024E74ED8C69060F20BBFE3_883950245 =         inflate(resource, root, root != null);
        varF5D4BA408024E74ED8C69060F20BBFE3_883950245.addTaint(taint);
        return varF5D4BA408024E74ED8C69060F20BBFE3_883950245;
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.290 -0400", hash_original_method = "2C6130928BF5FC4257D730B98F9E332E", hash_generated_method = "829289C726EE4EA13C7598D88A748D97")
    public View inflate(XmlPullParser parser, ViewGroup root) {
        addTaint(root.getTaint());
        addTaint(parser.getTaint());
View varD2994770AB4B2FBF2D952E8ECED55234_897404289 =         inflate(parser, root, root != null);
        varD2994770AB4B2FBF2D952E8ECED55234_897404289.addTaint(taint);
        return varD2994770AB4B2FBF2D952E8ECED55234_897404289;
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.291 -0400", hash_original_method = "73105F6C94DACD9E83BB5CE96738BE14", hash_generated_method = "A163CAA959AF5A9782F3B31880DDED1D")
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        addTaint(attachToRoot);
        addTaint(root.getTaint());
        addTaint(resource);
    if(DEBUG)        
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getLayout(resource);
        try 
        {
View var754E077DDE07C53AB996CC4C6A8F2A1A_747650761 =             inflate(parser, root, attachToRoot);
            var754E077DDE07C53AB996CC4C6A8F2A1A_747650761.addTaint(taint);
            return var754E077DDE07C53AB996CC4C6A8F2A1A_747650761;
        } //End block
        finally 
        {
            parser.close();
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getLayout(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.293 -0400", hash_original_method = "9DFC9AE5F080C22C20FBC66EE3D8715B", hash_generated_method = "41F458DCBFE309A62012C98450AFFAD5")
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        addTaint(attachToRoot);
        addTaint(root.getTaint());
        addTaint(parser.getTaint());
        synchronized
(mConstructorArgs)        {
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            Context lastContext = (Context)mConstructorArgs[0];
            mConstructorArgs[0] = mContext;
            View result = root;
            try 
            {
                int type;
                while
((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT)                
                {
                } //End block
    if(type != XmlPullParser.START_TAG)                
                {
                    InflateException varBF7F2731384F279DD8DADDE40FD4FA2A_1977278650 = new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                    varBF7F2731384F279DD8DADDE40FD4FA2A_1977278650.addTaint(taint);
                    throw varBF7F2731384F279DD8DADDE40FD4FA2A_1977278650;
                } //End block
                final String name = parser.getName();
    if(DEBUG)                
                {
                    System.out.println("**************************");
                    System.out.println("Creating root view: "
                            + name);
                    System.out.println("**************************");
                } //End block
    if(TAG_MERGE.equals(name))                
                {
    if(root == null || !attachToRoot)                    
                    {
                        InflateException var82F4326C85AA650E8E062571146DE3BE_1445488421 = new InflateException("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                        var82F4326C85AA650E8E062571146DE3BE_1445488421.addTaint(taint);
                        throw var82F4326C85AA650E8E062571146DE3BE_1445488421;
                    } //End block
                    rInflate(parser, root, attrs, false);
                } //End block
                else
                {
                    View temp;
    if(TAG_1995.equals(name))                    
                    {
                        temp = new BlinkLayout(mContext, attrs);
                    } //End block
                    else
                    {
                        temp = createViewFromTag(root, name, attrs);
                    } //End block
                    ViewGroup.LayoutParams params = null;
    if(root != null)                    
                    {
    if(DEBUG)                        
                        {
                            System.out.println("Creating params from root: " +
                                    root);
                        } //End block
                        params = root.generateLayoutParams(attrs);
    if(!attachToRoot)                        
                        {
                            temp.setLayoutParams(params);
                        } //End block
                    } //End block
    if(DEBUG)                    
                    {
                        System.out.println("-----> start inflating children");
                    } //End block
                    rInflate(parser, temp, attrs, true);
    if(DEBUG)                    
                    {
                        System.out.println("-----> done inflating children");
                    } //End block
    if(root != null && attachToRoot)                    
                    {
                        root.addView(temp, params);
                    } //End block
    if(root == null || !attachToRoot)                    
                    {
                        result = temp;
                    } //End block
                } //End block
            } //End block
            catch (XmlPullParserException e)
            {
                InflateException ex = new InflateException(e.getMessage());
                ex.initCause(e);
                ex.addTaint(taint);
                throw ex;
            } //End block
            catch (IOException e)
            {
                InflateException ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                ex.addTaint(taint);
                throw ex;
            } //End block
            finally 
            {
                mConstructorArgs[0] = lastContext;
                mConstructorArgs[1] = null;
            } //End block
View varDC838461EE2FA0CA4C9BBB70A15456B0_1506823090 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1506823090.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1506823090;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.294 -0400", hash_original_method = "9249249C6DEB7757C8882D406CD78B4B", hash_generated_method = "36D9FD4468B26752D26D232E6CB7F0D3")
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        addTaint(attrs.getTaint());
        addTaint(prefix.getTaint());
        addTaint(name.getTaint());
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        Class<? extends View> clazz = null;
        try 
        {
    if(constructor == null)            
            {
                clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name).asSubclass(View.class);
    if(mFilter != null && clazz != null)                
                {
                    boolean allowed = mFilter.onLoadClass(clazz);
    if(!allowed)                    
                    {
                        failNotAllowed(name, prefix, attrs);
                    } //End block
                } //End block
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } //End block
            else
            {
    if(mFilter != null)                
                {
                    Boolean allowedState = mFilterMap.get(name);
    if(allowedState == null)                    
                    {
                        clazz = mContext.getClassLoader().loadClass(
                                prefix != null ? (prefix + name) : name).asSubclass(View.class);
                        boolean allowed = clazz != null && mFilter.onLoadClass(clazz);
                        mFilterMap.put(name, allowed);
    if(!allowed)                        
                        {
                            failNotAllowed(name, prefix, attrs);
                        } //End block
                    } //End block
                    else
    if(allowedState.equals(Boolean.FALSE))                    
                    {
                        failNotAllowed(name, prefix, attrs);
                    } //End block
                } //End block
            } //End block
            Object[] args = mConstructorArgs;
            args[1] = attrs;
View var4A4697B81353FB366B444B5D55EB814F_486638908 =             constructor.newInstance(args);
            var4A4697B81353FB366B444B5D55EB814F_486638908.addTaint(taint);
            return var4A4697B81353FB366B444B5D55EB814F_486638908;
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        catch (ClassCastException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Class is not a View "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        catch (ClassNotFoundException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (clazz == null ? "<unknown>" : clazz.getName()));
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.295 -0400", hash_original_method = "0971FA0124FB7B31B88F61FC842AABEB", hash_generated_method = "E10B845F7F05997D107E5D8F8507D776")
    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(prefix.getTaint());
        addTaint(name.getTaint());
        InflateException var913E072F8AE7304769637C5265F04CD5_1751372081 = new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
        var913E072F8AE7304769637C5265F04CD5_1751372081.addTaint(taint);
        throw var913E072F8AE7304769637C5265F04CD5_1751372081;
        // ---------- Original Method ----------
        //throw new InflateException(attrs.getPositionDescription()
                //+ ": Class not allowed to be inflated "
                //+ (prefix != null ? (prefix + name) : name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.295 -0400", hash_original_method = "9A9783E7AF685525083052EAFC6937D8", hash_generated_method = "C39474C009A905F2F06623974297B275")
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(name.getTaint());
View varA415DC7CF57A628085818A3825C01FB1_1823293627 =         createView(name, "android.view.", attrs);
        varA415DC7CF57A628085818A3825C01FB1_1823293627.addTaint(taint);
        return varA415DC7CF57A628085818A3825C01FB1_1823293627;
        // ---------- Original Method ----------
        //return createView(name, "android.view.", attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.296 -0400", hash_original_method = "EEF2BD4B979EFD4F0FBDCDB52C08D7B2", hash_generated_method = "A5FCF064AAD400017EDF4501C30C8CC6")
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(name.getTaint());
        addTaint(parent.getTaint());
View var7421AB13C5D99D7D5B1FC4BEDFBA8EFD_2013273057 =         onCreateView(name, attrs);
        var7421AB13C5D99D7D5B1FC4BEDFBA8EFD_2013273057.addTaint(taint);
        return var7421AB13C5D99D7D5B1FC4BEDFBA8EFD_2013273057;
        // ---------- Original Method ----------
        //return onCreateView(name, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.297 -0400", hash_original_method = "42E00CE52BE01D0BF7040FF60139A865", hash_generated_method = "680DF8EA6BAEA777156A7FE1259EEA92")
     View createViewFromTag(View parent, String name, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(name.getTaint());
        addTaint(parent.getTaint());
    if(name.equals("view"))        
        {
            name = attrs.getAttributeValue(null, "class");
        } //End block
    if(DEBUG)        
        System.out.println("******** Creating view: " + name);
        try 
        {
            View view;
    if(mFactory2 != null)            
            view = mFactory2.onCreateView(parent, name, mContext, attrs);
            else
    if(mFactory != null)            
            view = mFactory.onCreateView(name, mContext, attrs);
            else
            view = null;
    if(view == null && mPrivateFactory != null)            
            {
                view = mPrivateFactory.onCreateView(parent, name, mContext, attrs);
            } //End block
    if(view == null)            
            {
    if(-1 == name.indexOf('.'))                
                {
                    view = onCreateView(parent, name, attrs);
                } //End block
                else
                {
                    view = createView(name, null, attrs);
                } //End block
            } //End block
    if(DEBUG)            
            System.out.println("Created view is: " + view);
View var057D265746AE9672AFE5F9FF6338071D_1043139585 =             view;
            var057D265746AE9672AFE5F9FF6338071D_1043139585.addTaint(taint);
            return var057D265746AE9672AFE5F9FF6338071D_1043139585;
        } //End block
        catch (InflateException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.298 -0400", hash_original_method = "3A61628D6ED69C72EF61CAE501BAE992", hash_generated_method = "DA24DC585F17699FF004CE6A3FBBAACA")
     void rInflate(XmlPullParser parser, View parent, final AttributeSet attrs,
            boolean finishInflate) throws XmlPullParserException, IOException {
        addTaint(finishInflate);
        addTaint(attrs.getTaint());
        addTaint(parent.getTaint());
        addTaint(parser.getTaint());
        final int depth = parser.getDepth();
        int type;
        while
(((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT)        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            final String name = parser.getName();
    if(TAG_REQUEST_FOCUS.equals(name))            
            {
                parseRequestFocus(parser, parent);
            } //End block
            else
    if(TAG_INCLUDE.equals(name))            
            {
    if(parser.getDepth() == 0)                
                {
                    InflateException varC2BEA8253C73659E8EED554741960CED_778037450 = new InflateException("<include /> cannot be the root element");
                    varC2BEA8253C73659E8EED554741960CED_778037450.addTaint(taint);
                    throw varC2BEA8253C73659E8EED554741960CED_778037450;
                } //End block
                parseInclude(parser, parent, attrs);
            } //End block
            else
    if(TAG_MERGE.equals(name))            
            {
                InflateException var1742B67301D3E89F3D7AAEBA0003F5C1_2125561046 = new InflateException("<merge /> must be the root element");
                var1742B67301D3E89F3D7AAEBA0003F5C1_2125561046.addTaint(taint);
                throw var1742B67301D3E89F3D7AAEBA0003F5C1_2125561046;
            } //End block
            else
    if(TAG_1995.equals(name))            
            {
                final View view = new BlinkLayout(mContext, attrs);
                final ViewGroup viewGroup = (ViewGroup) parent;
                final ViewGroup.LayoutParams params = viewGroup.generateLayoutParams(attrs);
                rInflate(parser, view, attrs, true);
                viewGroup.addView(view, params);
            } //End block
            else
            {
                final View view = createViewFromTag(parent, name, attrs);
                final ViewGroup viewGroup = (ViewGroup) parent;
                final ViewGroup.LayoutParams params = viewGroup.generateLayoutParams(attrs);
                rInflate(parser, view, attrs, true);
                viewGroup.addView(view, params);
            } //End block
        } //End block
    if(finishInflate)        
        parent.onFinishInflate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.299 -0400", hash_original_method = "D305B9D132FFD898328C34D4AEEA8981", hash_generated_method = "A28773FE12CAEE49892230B2567D41EF")
    private void parseRequestFocus(XmlPullParser parser, View parent) throws XmlPullParserException, IOException {
        addTaint(parent.getTaint());
        addTaint(parser.getTaint());
        int type;
        parent.requestFocus();
        final int currentDepth = parser.getDepth();
        while
(((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT)        
        {
        } //End block
        // ---------- Original Method ----------
        //int type;
        //parent.requestFocus();
        //final int currentDepth = parser.getDepth();
        //while (((type = parser.next()) != XmlPullParser.END_TAG ||
                //parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.301 -0400", hash_original_method = "3903965D4D2522F244AF5345C6CDB188", hash_generated_method = "70C76ECEA59DAD9D68532567BE5D8CA0")
    private void parseInclude(XmlPullParser parser, View parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parent.getTaint());
        addTaint(parser.getTaint());
        int type;
    if(parent instanceof ViewGroup)        
        {
            final int layout = attrs.getAttributeResourceValue(null, "layout", 0);
    if(layout == 0)            
            {
                final String value = attrs.getAttributeValue(null, "layout");
    if(value == null)                
                {
                    InflateException varBED71C54FF9270EDEFD4FCBE204F105D_496967736 = new InflateException("You must specifiy a layout in the"
                            + " include tag: <include layout=\"@layout/layoutID\" />");
                    varBED71C54FF9270EDEFD4FCBE204F105D_496967736.addTaint(taint);
                    throw varBED71C54FF9270EDEFD4FCBE204F105D_496967736;
                } //End block
                else
                {
                    InflateException var1F2D8A99DC8DD80F6CF7035D2493209C_25821744 = new InflateException("You must specifiy a valid layout "
                            + "reference. The layout ID " + value + " is not valid.");
                    var1F2D8A99DC8DD80F6CF7035D2493209C_25821744.addTaint(taint);
                    throw var1F2D8A99DC8DD80F6CF7035D2493209C_25821744;
                } //End block
            } //End block
            else
            {
                final XmlResourceParser childParser = getContext().getResources().getLayout(layout);
                try 
                {
                    final AttributeSet childAttrs = Xml.asAttributeSet(childParser);
                    while
((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT)                    
                    {
                    } //End block
    if(type != XmlPullParser.START_TAG)                    
                    {
                        InflateException varFCFD0253402DADC6B929C2F98725BFB0_2139694770 = new InflateException(childParser.getPositionDescription() +
                                ": No start tag found!");
                        varFCFD0253402DADC6B929C2F98725BFB0_2139694770.addTaint(taint);
                        throw varFCFD0253402DADC6B929C2F98725BFB0_2139694770;
                    } //End block
                    final String childName = childParser.getName();
    if(TAG_MERGE.equals(childName))                    
                    {
                        rInflate(childParser, parent, childAttrs, false);
                    } //End block
                    else
                    {
                        final View view = createViewFromTag(parent, childName, childAttrs);
                        final ViewGroup group = (ViewGroup) parent;
                        ViewGroup.LayoutParams params = null;
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
    if(params != null)                            
                            {
                                view.setLayoutParams(params);
                            } //End block
                        } //End block
                        rInflate(childParser, view, childAttrs, true);
                        TypedArray a = mContext.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.View, 0, 0);
                        int id = a.getResourceId(com.android.internal.R.styleable.View_id, View.NO_ID);
                        int visibility = a.getInt(com.android.internal.R.styleable.View_visibility, -1);
                        a.recycle();
    if(id != View.NO_ID)                        
                        {
                            view.setId(id);
                        } //End block
switch(visibility){
                        case 0:
                        view.setVisibility(View.VISIBLE);
                        break;
                        case 1:
                        view.setVisibility(View.INVISIBLE);
                        break;
                        case 2:
                        view.setVisibility(View.GONE);
                        break;
}                        group.addView(view);
                    } //End block
                } //End block
                finally 
                {
                    childParser.close();
                } //End block
            } //End block
        } //End block
        else
        {
            InflateException var60C2BB7A3404855EA7538D9AF0A12140_714394916 = new InflateException("<include /> can only be used inside of a ViewGroup");
            var60C2BB7A3404855EA7538D9AF0A12140_714394916.addTaint(taint);
            throw var60C2BB7A3404855EA7538D9AF0A12140_714394916;
        } //End block
        final int currentDepth = parser.getDepth();
        while
(((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT)        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FactoryMerger implements Factory2 {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.302 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "5597E72774649F58EAFC93193B0F56F5")

        private Factory mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.302 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "980C2131F1904820A671FBE786E0A976")

        private Factory mF2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.302 -0400", hash_original_field = "EFB292FB0A8C321793AF25ADBD699004", hash_generated_field = "F581D9BC63EDDF42FCA0DB75903DA713")

        private Factory2 mF12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.302 -0400", hash_original_field = "F95B8BEDDD7E63CA0369D2E0B75E60F0", hash_generated_field = "279141595E6D3718BC3E6B02DB3437E1")

        private Factory2 mF22;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.303 -0400", hash_original_method = "E5AD3FF1F375743BB365B35578675E98", hash_generated_method = "2C2C626FEF544A6A4B4A2A329D6C4155")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.304 -0400", hash_original_method = "912C6EE593A6921C8E87D5E0641D7CDD", hash_generated_method = "981C75C0D80DDC017639D5DCAF0829F8")
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            View v = mF1.onCreateView(name, context, attrs);
    if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_627150657 =             v;
            var6DC76BC51820DD65E8396280E884AA78_627150657.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_627150657;
            }
View varD559DA7AD46B63303AC4B99BC0A5AD0E_695343260 =             mF2.onCreateView(name, context, attrs);
            varD559DA7AD46B63303AC4B99BC0A5AD0E_695343260.addTaint(taint);
            return varD559DA7AD46B63303AC4B99BC0A5AD0E_695343260;
            // ---------- Original Method ----------
            //View v = mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF2.onCreateView(name, context, attrs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.304 -0400", hash_original_method = "F1957EAE5145EA0F0129265F270794D6", hash_generated_method = "8DFB704134D87B39410A05F0057C15FE")
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            addTaint(parent.getTaint());
            View v = mF12 != null ? mF12.onCreateView(parent, name, context, attrs)
                    : mF1.onCreateView(name, context, attrs);
    if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_1540367518 =             v;
            var6DC76BC51820DD65E8396280E884AA78_1540367518.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_1540367518;
            }
View var055A44BB32643942C424748EC4A9CD57_852221574 =             mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    : mF2.onCreateView(name, context, attrs);
            var055A44BB32643942C424748EC4A9CD57_852221574.addTaint(taint);
            return var055A44BB32643942C424748EC4A9CD57_852221574;
            // ---------- Original Method ----------
            //View v = mF12 != null ? mF12.onCreateView(parent, name, context, attrs)
                    //: mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    //: mF2.onCreateView(name, context, attrs);
        }

        
    }


    
    private static class BlinkLayout extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.305 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "9F94E2291878F4B79ED3B6B67A1ED0C7")

        private boolean mBlink;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.305 -0400", hash_original_field = "84A61AEDD18A7D6ECA3FB13967806C7E", hash_generated_field = "57E34B9F322B663DA6033C74FD1E64C4")

        private boolean mBlinkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.305 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.308 -0400", hash_original_method = "3DD68C66D41BE889B84232F33376A99A", hash_generated_method = "E7D9E506869CCA9E603CA8BD4A008D94")
        public  BlinkLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            mHandler = new Handler(new Handler.Callback() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.307 -0400", hash_original_method = "3CDE63BB1E6E2FE4ACBB53B93DE4CB6C", hash_generated_method = "616E778ABA570E166E676EBB5634A193")
            @Override
            public boolean handleMessage(Message msg) {
                addTaint(msg.getTaint());
    if(msg.what == MESSAGE_BLINK)                
                {
    if(mBlink)                    
                    {
                        mBlinkState = !mBlinkState;
                        makeBlink();
                    } //End block
                    invalidate();
                    boolean varB326B5062B2F0E69046810717534CB09_253433065 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200168825 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200168825;
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_1121732310 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766422598 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_766422598;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.308 -0400", hash_original_method = "553FA2CA85816FF11073226F48838667", hash_generated_method = "00C0A90E7BA24936A24ED91BF6920ACE")
        private void makeBlink() {
            Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            mHandler.sendMessageDelayed(message, BLINK_DELAY);
            // ---------- Original Method ----------
            //Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            //mHandler.sendMessageDelayed(message, BLINK_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.309 -0400", hash_original_method = "F84801EA6DE017B4DF3D928CA8059755", hash_generated_method = "5442A9264ED4F4E31C0BA66C5931886A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.310 -0400", hash_original_method = "68779D94DBD6ED32D8C444331B18EB29", hash_generated_method = "A65982EADCE2056B98837C8AE9E7BCE2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.310 -0400", hash_original_method = "B2A7E99D93A7E570FADBB759CB038122", hash_generated_method = "22991FF637186B632437C8B5D9E6FE9D")
        @Override
        protected void dispatchDraw(Canvas canvas) {
            addTaint(canvas.getTaint());
    if(mBlinkState)            
            {
                super.dispatchDraw(canvas);
            } //End block
            // ---------- Original Method ----------
            //if (mBlinkState) {
                //super.dispatchDraw(canvas);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "FCC4B1B643B64678EC5C05DB4601EBF9", hash_generated_field = "4A3D47FA8808A8239672ED34E6BFB3B1")

        private static final int MESSAGE_BLINK = 0x42;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "C0C33B4F311995BA1D316E6C41B33B82", hash_generated_field = "D5B9EC9F6E148AEB7231E8904BDB2F8F")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "63DF1F110DEB7B86F6BD18817F9A4731")

    static final Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "176CD41BE1EF5E4979EA824C2AEDF2B1", hash_generated_field = "C38DE3F776CAFB12B475430CF0EEAA23")

    private static final HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap<String, Constructor<? extends View>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "EED9DF1080CAF39D9C37A9B5067943FA", hash_generated_field = "36C7BA0C809B7EB42A272F2829D1F77B")

    private static final String TAG_MERGE = "merge";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "932E55CE33B67AAED6E42C38C17410C7", hash_generated_field = "E44225DBBDDDD64E37F1DAB51EE83BFC")

    private static final String TAG_INCLUDE = "include";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "EB60FFD74626EBCFC26C23DBDF32C98B", hash_generated_field = "D5A8197B8C970976D34EB44455934252")

    private static final String TAG_1995 = "blink";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.311 -0400", hash_original_field = "10D3EBD501FBA20B3D43BF08D4F12183", hash_generated_field = "245DD97419AEA5026E042D1B40675C79")

    private static final String TAG_REQUEST_FOCUS = "requestFocus";
}

