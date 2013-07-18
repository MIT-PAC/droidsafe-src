package android.preference;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract class GenericInflater<T, P extends GenericInflater.Parent> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.260 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "40AF400BA8F86FA9C9E428F903D03FF5")

    private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "05BA2F2FD6F3066B67DC96510DE31D25")

    private Factory<T> mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "BAC245513231B6A4CDBDF61862A69933")

    private final Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_field = "16CD905047E4400746288B9C013DD010", hash_generated_field = "6581AC575AE1E4EEB60567A9B3808F54")

    private String mDefaultPackage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.261 -0400", hash_original_method = "A8AA332702376B454A767A9414B9F159", hash_generated_method = "FB5B2F7669C654AD5EBC4C0486706ABC")
    protected  GenericInflater(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.262 -0400", hash_original_method = "6B35BDBE0F984168A951D53A5AF8F867", hash_generated_method = "5B3124184A7A1A83CB974DBE9483156C")
    protected  GenericInflater(GenericInflater<T,P> original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
        // ---------- Original Method ----------
        //mContext = newContext;
        //mFactory = original.mFactory;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract GenericInflater cloneInContext(Context newContext);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.262 -0400", hash_original_method = "601AA595429A3B000CED526A81A8472C", hash_generated_method = "7BC7A6A5CCACB62BC0C669BFFD05EDF1")
    public void setDefaultPackage(String defaultPackage) {
        mDefaultPackage = defaultPackage;
        // ---------- Original Method ----------
        //mDefaultPackage = defaultPackage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.263 -0400", hash_original_method = "46E608B0485504B383BE067A0BD6622F", hash_generated_method = "49E67FC54BA7D854FBB80A0BF83FE3AB")
    public String getDefaultPackage() {
String varF2E95DF9778A091AD1F79240098DBF1E_989974942 =         mDefaultPackage;
        varF2E95DF9778A091AD1F79240098DBF1E_989974942.addTaint(taint);
        return varF2E95DF9778A091AD1F79240098DBF1E_989974942;
        // ---------- Original Method ----------
        //return mDefaultPackage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.263 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4256EA05A98A8C7DA2AA98C74E67F58F")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_2056492028 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2056492028.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2056492028;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.263 -0400", hash_original_method = "E145074F4BEE68EC84A4CE1558E8DDDD", hash_generated_method = "74110D08944C98ACD7769A9AA8B957B2")
    public final Factory<T> getFactory() {
Factory<T> var086273A71AC89A5E1A3A59778647C1F0_2079476501 =         mFactory;
        var086273A71AC89A5E1A3A59778647C1F0_2079476501.addTaint(taint);
        return var086273A71AC89A5E1A3A59778647C1F0_2079476501;
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.264 -0400", hash_original_method = "F731ABA6658EE884292BF19729B20DA7", hash_generated_method = "C47E781F64CDDE4068AA6C41EB50A8A6")
    public void setFactory(Factory<T> factory) {
        if(mFactorySet)        
        {
            IllegalStateException var0C04ECB822399DA6A3F6B017EFDA36E7_754398862 = new IllegalStateException("" +
            		"A factory has already been set on this inflater");
            var0C04ECB822399DA6A3F6B017EFDA36E7_754398862.addTaint(taint);
            throw var0C04ECB822399DA6A3F6B017EFDA36E7_754398862;
        } //End block
        if(factory == null)        
        {
            NullPointerException var4E80D5BF81BCD97DD9195749F4C7E02F_1536250933 = new NullPointerException("Given factory can not be null");
            var4E80D5BF81BCD97DD9195749F4C7E02F_1536250933.addTaint(taint);
            throw var4E80D5BF81BCD97DD9195749F4C7E02F_1536250933;
        } //End block
        mFactorySet = true;
        if(mFactory == null)        
        {
            mFactory = factory;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.265 -0400", hash_original_method = "0AF1546F925E79A6FCD8229E5389F782", hash_generated_method = "8B0AC59FDC346051DB5AED48FA200C69")
    public T inflate(int resource, P root) {
        addTaint(root.getTaint());
        addTaint(resource);
T varF5D4BA408024E74ED8C69060F20BBFE3_1265977232 =         inflate(resource, root, root != null);
        varF5D4BA408024E74ED8C69060F20BBFE3_1265977232.addTaint(taint);
        return varF5D4BA408024E74ED8C69060F20BBFE3_1265977232;
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.265 -0400", hash_original_method = "A09A6320AB1158C141A52528AA964FE1", hash_generated_method = "2C97B540B26A893B3AC825B6BC62AF3E")
    public T inflate(XmlPullParser parser, P root) {
        addTaint(root.getTaint());
        addTaint(parser.getTaint());
T varD2994770AB4B2FBF2D952E8ECED55234_1705446812 =         inflate(parser, root, root != null);
        varD2994770AB4B2FBF2D952E8ECED55234_1705446812.addTaint(taint);
        return varD2994770AB4B2FBF2D952E8ECED55234_1705446812;
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.265 -0400", hash_original_method = "C3BB64443334F9B40F1AFC79B102744E", hash_generated_method = "39E9D8BFE96182961C41647EEC90AC2A")
    public T inflate(int resource, P root, boolean attachToRoot) {
        addTaint(attachToRoot);
        addTaint(root.getTaint());
        addTaint(resource);
        if(DEBUG)        
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getXml(resource);
        try 
        {
T var754E077DDE07C53AB996CC4C6A8F2A1A_165520371 =             inflate(parser, root, attachToRoot);
            var754E077DDE07C53AB996CC4C6A8F2A1A_165520371.addTaint(taint);
            return var754E077DDE07C53AB996CC4C6A8F2A1A_165520371;
        } //End block
        finally 
        {
            parser.close();
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getXml(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.267 -0400", hash_original_method = "93981E75696898B46E3B07FB71CA5701", hash_generated_method = "EA6E36FD19BE62B52B3C3B1D782E3DEE")
    public T inflate(XmlPullParser parser, P root,
            boolean attachToRoot) {
        addTaint(attachToRoot);
        addTaint(root.getTaint());
        addTaint(parser.getTaint());
        synchronized
(mConstructorArgs)        {
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            mConstructorArgs[0] = mContext;
            T result = (T) root;
            try 
            {
                int type;
                while
((type = parser.next()) != parser.START_TAG
                        && type != parser.END_DOCUMENT)                
                {
                    ;
                } //End block
                if(type != parser.START_TAG)                
                {
                    InflateException varBF7F2731384F279DD8DADDE40FD4FA2A_1582875430 = new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                    varBF7F2731384F279DD8DADDE40FD4FA2A_1582875430.addTaint(taint);
                    throw varBF7F2731384F279DD8DADDE40FD4FA2A_1582875430;
                } //End block
                if(DEBUG)                
                {
                    System.out.println("**************************");
                    System.out.println("Creating root: "
                            + parser.getName());
                    System.out.println("**************************");
                } //End block
                T xmlRoot = createItemFromTag(parser, parser.getName(),
                        attrs);
                result = (T) onMergeRoots(root, attachToRoot, (P) xmlRoot);
                if(DEBUG)                
                {
                    System.out.println("-----> start inflating children");
                } //End block
                rInflate(parser, result, attrs);
                if(DEBUG)                
                {
                    System.out.println("-----> done inflating children");
                } //End block
            } //End block
            catch (InflateException e)
            {
                e.addTaint(taint);
                throw e;
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
T varDC838461EE2FA0CA4C9BBB70A15456B0_1097536505 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1097536505.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1097536505;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.268 -0400", hash_original_method = "AB0D32CECCD43C7D0F0360210FD11363", hash_generated_method = "971D910D1B61B74DCC91651DE1203EA7")
    public final T createItem(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        addTaint(attrs.getTaint());
        addTaint(prefix.getTaint());
        addTaint(name.getTaint());
        Constructor constructor = (Constructor) sConstructorMap.get(name);
        try 
        {
            if(null == constructor)            
            {
                Class clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } //End block
            Object[] args = mConstructorArgs;
            args[1] = attrs;
T var9A2B10BE0D166EB47CE47038525DA5F1_1324217993 =             (T) constructor.newInstance(args);
            var9A2B10BE0D166EB47CE47038525DA5F1_1324217993.addTaint(taint);
            return var9A2B10BE0D166EB47CE47038525DA5F1_1324217993;
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
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
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + constructor.getClass().getName());
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.268 -0400", hash_original_method = "4FBBE2487A51D08C4064228D927262EC", hash_generated_method = "0ECC363B2BE1A92672DFBF2F3437C061")
    protected T onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(name.getTaint());
T var19048E9B5FBA4BA561E1AC6C48A6F349_1005244084 =         createItem(name, mDefaultPackage, attrs);
        var19048E9B5FBA4BA561E1AC6C48A6F349_1005244084.addTaint(taint);
        return var19048E9B5FBA4BA561E1AC6C48A6F349_1005244084;
        // ---------- Original Method ----------
        //return createItem(name, mDefaultPackage, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.270 -0400", hash_original_method = "8A20619C5B186F5C05E29B17BC664D21", hash_generated_method = "D2B193FF9F143D2903EE19489E32C6D8")
    private final T createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(name.getTaint());
        addTaint(parser.getTaint());
        if(DEBUG)        
        System.out.println("******** Creating item: " + name);
        try 
        {
            T item = (mFactory == null) ? null : mFactory.onCreateItem(name, mContext, attrs);
            if(item == null)            
            {
                if(-1 == name.indexOf('.'))                
                {
                    item = onCreateItem(name, attrs);
                } //End block
                else
                {
                    item = createItem(name, null, attrs);
                } //End block
            } //End block
            if(DEBUG)            
            System.out.println("Created item is: " + item);
T var393CF4FD24220F0ED4B080A1E7108CD3_761532127 =             item;
            var393CF4FD24220F0ED4B080A1E7108CD3_761532127.addTaint(taint);
            return var393CF4FD24220F0ED4B080A1E7108CD3_761532127;
        } //End block
        catch (InflateException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            ie.addTaint(taint);
            throw ie;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.271 -0400", hash_original_method = "DD09A710ED93B5E593984A56AAF093F3", hash_generated_method = "CA8186DA00BF87069C9E2D4E182CAF7F")
    private void rInflate(XmlPullParser parser, T parent, final AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parent.getTaint());
        addTaint(parser.getTaint());
        final int depth = parser.getDepth();
        int type;
        while
(((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT)        
        {
            if(type != parser.START_TAG)            
            {
                continue;
            } //End block
            if(onCreateCustomFromTag(parser, parent, attrs))            
            {
                continue;
            } //End block
            if(DEBUG)            
            {
                System.out.println("Now inflating tag: " + parser.getName());
            } //End block
            String name = parser.getName();
            T item = createItemFromTag(parser, name, attrs);
            if(DEBUG)            
            {
                System.out
                        .println("Creating params from parent: " + parent);
            } //End block
            ((P) parent).addItemFromInflater(item);
            if(DEBUG)            
            {
                System.out.println("-----> start inflating children");
            } //End block
            rInflate(parser, item, attrs);
            if(DEBUG)            
            {
                System.out.println("-----> done inflating children");
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.271 -0400", hash_original_method = "19860FA740DE510446609E99D1C237FB", hash_generated_method = "5108F3E9BF91F76D2BE48EBBE0C35417")
    protected boolean onCreateCustomFromTag(XmlPullParser parser, T parent,
            final AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(parent.getTaint());
        addTaint(parser.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1091531995 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182355099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182355099;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.272 -0400", hash_original_method = "5E31CC12237E180F4815989ECA3F6501", hash_generated_method = "D85EF33A8840B6578261E57BD207FAAF")
    protected P onMergeRoots(P givenRoot, boolean attachToGivenRoot, P xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(xmlRoot.getTaint());
        addTaint(attachToGivenRoot);
        addTaint(givenRoot.getTaint());
P varCBFCBF588E89F8CE897CCC58BE8F27B0_1886547367 =         xmlRoot;
        varCBFCBF588E89F8CE897CCC58BE8F27B0_1886547367.addTaint(taint);
        return varCBFCBF588E89F8CE897CCC58BE8F27B0_1886547367;
        // ---------- Original Method ----------
        //return xmlRoot;
    }

    
    private static class FactoryMerger<T> implements Factory<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.272 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "C926E99D17BAF92FDF4D7BA2DC2DD9F0")

        private Factory<T> mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.272 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "B5C59E0FE8A8E61FE994C8B9CBE70464")

        private Factory<T> mF2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.273 -0400", hash_original_method = "8268493149B8E87B72D799F680E0E2F1", hash_generated_method = "FB850E006E1460B7A165BF692F36AEC9")
          FactoryMerger(Factory<T> f1, Factory<T> f2) {
            mF1 = f1;
            mF2 = f2;
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.273 -0400", hash_original_method = "361561DAAA3A2CCBFCF79A32350158C1", hash_generated_method = "0FCF889E63E0E858CB3F4F453874D53B")
        public T onCreateItem(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            T v = mF1.onCreateItem(name, context, attrs);
            if(v != null)            
            {
T var6DC76BC51820DD65E8396280E884AA78_779905910 =             v;
            var6DC76BC51820DD65E8396280E884AA78_779905910.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_779905910;
            }
T varEDA26570C89C7D761435D65AB1648A6B_954114549 =             mF2.onCreateItem(name, context, attrs);
            varEDA26570C89C7D761435D65AB1648A6B_954114549.addTaint(taint);
            return varEDA26570C89C7D761435D65AB1648A6B_954114549;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.273 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "DA025B3CEA9F6DF229E9360E35C80379")

    private static final Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.273 -0400", hash_original_field = "ED0AF6FEF41982C7629A46F07C222461", hash_generated_field = "61C67D80619B2C9C71EFD304BA972A02")

    private static final HashMap sConstructorMap = new HashMap();
}

