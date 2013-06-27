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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.093 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.093 -0400", hash_original_field = "27BE8418CD2C41085C56252D66167B09", hash_generated_field = "AE81573D9500136C0B4AD5C6FB30BF01")

    private String specTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "A9CA5BD4BAA700E88830DCFF7AD67FEB", hash_generated_field = "8AC9ABDDED2DE61D44AD918D71798BCD")

    private String specVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "FE58BF3FA67BADE321C76927A734238B", hash_generated_field = "09287EC9275D23DEE889105D11CDB13B")

    private String specVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "5431B7E3ED1CCEC2EC752FF853A0F654", hash_generated_field = "85F560479896D7F78D6BB28FAF454380")

    private String implTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "B217C1BB739B1B8D51BC51E9C3451F61", hash_generated_field = "D5CDC04B85CD9B13DDD14861DBF2473C")

    private String implVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "F360209BFBB0A5D3C28E1276CDA50BFA", hash_generated_field = "3329CC794A5B24A56B07AB39A5F7B7A7")

    private String implVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.095 -0400", hash_original_field = "085A51E53C69361C2CD178128DADFA4D", hash_generated_field = "E6323554A81EBA1D12B93E5F630D84CC")

    private URL sealBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.096 -0400", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "8B54440B05CE69FA7889906BBB357BE1")
      Package(String name, String specTitle, String specVersion, String specVendor,
            String implTitle, String implVersion, String implVendor, URL sealBase) {
        this.name = name;
        this.specTitle = specTitle;
        this.specVersion = specVersion;
        this.specVendor = specVendor;
        this.implTitle = implTitle;
        this.implVersion = implVersion;
        this.implVendor = implVendor;
        this.sealBase = sealBase;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.111 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "55B9EBFD607AE1B3129A694474576825")
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_1945277506 = null; //Variable for return #1
        A varB4EAC82CA7396A68D541C85D26508E83_1325746539 = null; //Variable for return #2
        {
            Iterator<Annotation> var60115E277671C11EC1A8C18FCA7059DE_1469787915 = (getAnnotations()).iterator();
            var60115E277671C11EC1A8C18FCA7059DE_1469787915.hasNext();
            Annotation annotation = var60115E277671C11EC1A8C18FCA7059DE_1469787915.next();
            {
                {
                    boolean var7B7B6346786911875D9C711693128818_1244046660 = (annotationType.isInstance(annotation));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1945277506 = (A) annotation;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1325746539 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_2142299396; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2142299396 = varB4EAC82CA7396A68D541C85D26508E83_1945277506;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2142299396 = varB4EAC82CA7396A68D541C85D26508E83_1325746539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2142299396.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2142299396;
        // ---------- Original Method ----------
        //for (Annotation annotation : getAnnotations()) {
            //if (annotationType.isInstance(annotation)) {
                //return (A) annotation;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.121 -0400", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "2427D0AF001322DAB7903BDF90E517E9")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1009369350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1009369350 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_1009369350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1009369350;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.122 -0400", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "1915F4AD4E0EC5384C44314361D32E27")
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_642258869 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_642258869 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_642258869.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_642258869;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.122 -0400", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "F76F1E2B54E49FFD4AEE6288F061C53E")
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        boolean varDDEB039E2721937655C903B84DC79D17_899206333 = (getAnnotation(annotationType) != null);
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905119932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905119932;
        // ---------- Original Method ----------
        //return getAnnotation(annotationType) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.122 -0400", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "FBFD5D5E7409D40E5B9C5BDB05657F5B")
    public String getImplementationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_1359606304 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1359606304 = implTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1359606304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1359606304;
        // ---------- Original Method ----------
        //return implTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.123 -0400", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "CF848CCE8B50A71F004BC800A7B034D5")
    public String getImplementationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1719973945 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1719973945 = implVendor;
        varB4EAC82CA7396A68D541C85D26508E83_1719973945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1719973945;
        // ---------- Original Method ----------
        //return implVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.123 -0400", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "E9F5107CA0AE917CBE113F0D6F3E8424")
    public String getImplementationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1484647200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1484647200 = implVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1484647200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1484647200;
        // ---------- Original Method ----------
        //return implVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.175 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "51664C6D186DF8A572CD119D725B2FC9")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1284698643 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1284698643 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1284698643.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284698643;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.185 -0400", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "90424011A7251B52C3D82B0AB1C2B40A")
    public String getSpecificationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_303716941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_303716941 = specTitle;
        varB4EAC82CA7396A68D541C85D26508E83_303716941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_303716941;
        // ---------- Original Method ----------
        //return specTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.185 -0400", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "62DBE3B36687C1E7F9844CC63DE69E94")
    public String getSpecificationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1591231200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1591231200 = specVendor;
        varB4EAC82CA7396A68D541C85D26508E83_1591231200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1591231200;
        // ---------- Original Method ----------
        //return specVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.186 -0400", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "C9C7FB45777E34A45EF5ABB4D5CC1BA8")
    public String getSpecificationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_196891947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_196891947 = specVersion;
        varB4EAC82CA7396A68D541C85D26508E83_196891947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196891947;
        // ---------- Original Method ----------
        //return specVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.190 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "150F2C45CF54F12FEF4A03E3FC9A8F94")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_1505871394 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210295579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210295579;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.190 -0400", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "F95C972B78FC47C6590E8C7B8AF75C41")
    public boolean isCompatibleWith(String version) throws NumberFormatException {
        String[] requested;
        requested = version.split("\\.");
        String[] provided;
        provided = specVersion.split("\\.");
        {
            int i;
            i = 0;
            boolean var10D22493B0E3EBBF2ADDBE9CEDE0714A_1299135600 = (i < Math.min(requested.length, provided.length));
            {
                int reqNum;
                reqNum = Integer.parseInt(requested[i]);
                int provNum;
                provNum = Integer.parseInt(provided[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928583416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928583416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.191 -0400", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "84CB3C474A6C673039D84C2466BFEAF8")
    public boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883731394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883731394;
        // ---------- Original Method ----------
        //return sealBase != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.191 -0400", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "3B041B152EEF54A436CE8AF853B05291")
    public boolean isSealed(URL url) {
        boolean varACBE1F9FCC34100F410205F440770D39_1743650042 = (sealBase != null && sealBase.sameFile(url));
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606862695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_606862695;
        // ---------- Original Method ----------
        //return sealBase != null && sealBase.sameFile(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.199 -0400", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "5987EBD7D782E0A92D68A92ADD234484")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_339524466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339524466 = "package " + name;
        varB4EAC82CA7396A68D541C85D26508E83_339524466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339524466;
        // ---------- Original Method ----------
        //return "package " + name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.199 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "603764DDDF55C39C182DF3078A4D0CCC")

    private static Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

