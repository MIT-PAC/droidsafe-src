package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMStack;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;

public class Package implements AnnotatedElement {
    private String name;
    private String specTitle;
    private String specVersion;
    private String specVendor;
    private String implTitle;
    private String implVersion;
    private String implVendor;
    private URL sealBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.912 -0400", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "68D09EBEEF00D37D120E902E44A1FFE3")
    @DSModeled(DSC.SAFE)
     Package(String name, String specTitle, String specVersion, String specVendor,
            String implTitle, String implVersion, String implVendor, URL sealBase) {
        dsTaint.addTaint(specVersion);
        dsTaint.addTaint(sealBase.dsTaint);
        dsTaint.addTaint(implVendor);
        dsTaint.addTaint(specTitle);
        dsTaint.addTaint(implVersion);
        dsTaint.addTaint(name);
        dsTaint.addTaint(specVendor);
        dsTaint.addTaint(implTitle);
        // ---------- Original Method ----------
        //this.name = name;
        //this.specTitle = specTitle;
        //this.specVersion = specVersion;
        //this.specVendor = specVendor;
        //this.implTitle = implTitle;
        //this.implVersion = implVersion;
        //this.implVendor = implVendor;
        //this.sealBase = sealBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "91CB7D544A4B1C2B046C6A907F9C9ED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            Iterator<Annotation> var60115E277671C11EC1A8C18FCA7059DE_2033140589 = (getAnnotations()).iterator();
            var60115E277671C11EC1A8C18FCA7059DE_2033140589.hasNext();
            Annotation annotation = var60115E277671C11EC1A8C18FCA7059DE_2033140589.next();
            {
                {
                    boolean var7B7B6346786911875D9C711693128818_1880322987 = (annotationType.isInstance(annotation));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (A)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (Annotation annotation : getAnnotations()) {
            //if (annotationType.isInstance(annotation)) {
                //return (A) annotation;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "97D574B318EBF14495D705C6198C1CD7")
    @DSModeled(DSC.SAFE)
    public Annotation[] getAnnotations() {
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "22055A490679903DBBB4BE692E1061DE")
    @DSModeled(DSC.SAFE)
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "CCC1527C289A91422663E96B96585947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        boolean varDDEB039E2721937655C903B84DC79D17_1742798850 = (getAnnotation(annotationType) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAnnotation(annotationType) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "829A7F2E5A2BB6BFD3AD0B2AA5F6ECA7")
    @DSModeled(DSC.SAFE)
    public String getImplementationTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return implTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.914 -0400", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "0DFF0C222C9ECD8C29F75C5C60029FB7")
    @DSModeled(DSC.SAFE)
    public String getImplementationVendor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return implVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "D3EDA7166C5381D61A4F7F4BE74F8454")
    @DSModeled(DSC.SAFE)
    public String getImplementationVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return implVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
        public static Package getPackage(String packageName) {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackage(packageName);
    }

    
        public static Package[] getPackages() {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "EB23102A7DCE9AD1B65BE5D6F85B6A8B")
    @DSModeled(DSC.SAFE)
    public String getSpecificationTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return specTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "C041D809B4C27E8FC11E09C35A960282")
    @DSModeled(DSC.SAFE)
    public String getSpecificationVendor() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return specVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "210EAE9BB6409E727F172A54AA2852A5")
    @DSModeled(DSC.SAFE)
    public String getSpecificationVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return specVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.915 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "310023F9C6A6B68C0970096F4F730EB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_603155543 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.916 -0400", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "79469EB1BF130513C491A60269CEBB16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCompatibleWith(String version) throws NumberFormatException {
        dsTaint.addTaint(version);
        String[] requested;
        requested = version.split("\\.");
        String[] provided;
        provided = specVersion.split("\\.");
        {
            int i;
            i = 0;
            boolean var10D22493B0E3EBBF2ADDBE9CEDE0714A_303600514 = (i < Math.min(requested.length, provided.length));
            {
                int reqNum;
                reqNum = Integer.parseInt(requested[i]);
                int provNum;
                provNum = Integer.parseInt(provided[i]);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String[] requested = version.split("\\.");
        //String[] provided = specVersion.split("\\.");
        //for (int i = 0; i < Math.min(requested.length, provided.length); i++) {
            //int reqNum = Integer.parseInt(requested[i]);
            //int provNum = Integer.parseInt(provided[i]);
            //if (reqNum > provNum) {
                //return false;
            //} else if (reqNum < provNum) {
                //return true;
            //}
        //}
        //if (requested.length > provided.length) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.916 -0400", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "E029D1C40C54532C42FF8CEA2F9AED7D")
    @DSModeled(DSC.SAFE)
    public boolean isSealed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sealBase != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.916 -0400", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "38B95F55B62CFA277DBCDA6B59A5E9AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSealed(URL url) {
        dsTaint.addTaint(url.dsTaint);
        boolean varACBE1F9FCC34100F410205F440770D39_987644085 = (sealBase != null && sealBase.sameFile(url));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sealBase != null && sealBase.sameFile(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.916 -0400", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "F8F3CA189E0204C0E592C2DB4BEC38DD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "package " + name;
    }

    
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

