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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "27BE8418CD2C41085C56252D66167B09", hash_generated_field = "AE81573D9500136C0B4AD5C6FB30BF01")

    private String specTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "A9CA5BD4BAA700E88830DCFF7AD67FEB", hash_generated_field = "8AC9ABDDED2DE61D44AD918D71798BCD")

    private String specVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "FE58BF3FA67BADE321C76927A734238B", hash_generated_field = "09287EC9275D23DEE889105D11CDB13B")

    private String specVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "5431B7E3ED1CCEC2EC752FF853A0F654", hash_generated_field = "85F560479896D7F78D6BB28FAF454380")

    private String implTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "B217C1BB739B1B8D51BC51E9C3451F61", hash_generated_field = "D5CDC04B85CD9B13DDD14861DBF2473C")

    private String implVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "F360209BFBB0A5D3C28E1276CDA50BFA", hash_generated_field = "3329CC794A5B24A56B07AB39A5F7B7A7")

    private String implVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.987 -0400", hash_original_field = "085A51E53C69361C2CD178128DADFA4D", hash_generated_field = "E6323554A81EBA1D12B93E5F630D84CC")

    private URL sealBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.988 -0400", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "8B54440B05CE69FA7889906BBB357BE1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.047 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "B949520ABE81467834B5D7B571B9251C")
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_2101793271 = null; //Variable for return #1
        A varB4EAC82CA7396A68D541C85D26508E83_1235354069 = null; //Variable for return #2
        {
            Iterator<Annotation> var60115E277671C11EC1A8C18FCA7059DE_1728540922 = (getAnnotations()).iterator();
            var60115E277671C11EC1A8C18FCA7059DE_1728540922.hasNext();
            Annotation annotation = var60115E277671C11EC1A8C18FCA7059DE_1728540922.next();
            {
                {
                    boolean var7B7B6346786911875D9C711693128818_1307975548 = (annotationType.isInstance(annotation));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2101793271 = (A) annotation;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1235354069 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_1446975806; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1446975806 = varB4EAC82CA7396A68D541C85D26508E83_2101793271;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1446975806 = varB4EAC82CA7396A68D541C85D26508E83_1235354069;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1446975806.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1446975806;
        // ---------- Original Method ----------
        //for (Annotation annotation : getAnnotations()) {
            //if (annotationType.isInstance(annotation)) {
                //return (A) annotation;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.049 -0400", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "053977F7CF266E4440381AB67419D7AD")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1004059066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004059066 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_1004059066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004059066;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.050 -0400", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "2074EDC14958FDFB84F59549DD7AB02C")
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1590789895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1590789895 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_1590789895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590789895;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.050 -0400", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "CB278738DB3AE70277966884500D21D6")
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        boolean varDDEB039E2721937655C903B84DC79D17_777149275 = (getAnnotation(annotationType) != null);
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163112724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163112724;
        // ---------- Original Method ----------
        //return getAnnotation(annotationType) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.051 -0400", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "40DC3059698CD9E720B18B10ED233F42")
    public String getImplementationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_2040272124 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2040272124 = implTitle;
        varB4EAC82CA7396A68D541C85D26508E83_2040272124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040272124;
        // ---------- Original Method ----------
        //return implTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.058 -0400", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "42CB09AA2BDDBF9BA0BA1FAD8B207D13")
    public String getImplementationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_2006916317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2006916317 = implVendor;
        varB4EAC82CA7396A68D541C85D26508E83_2006916317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2006916317;
        // ---------- Original Method ----------
        //return implVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.058 -0400", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "2D937CF9FDF8FD82EDB788E2BE7F5A20")
    public String getImplementationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_697884953 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_697884953 = implVersion;
        varB4EAC82CA7396A68D541C85D26508E83_697884953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697884953;
        // ---------- Original Method ----------
        //return implVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.060 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A49B861A739825A7C06AB2C00DB1C1B4")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_439826085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439826085 = name;
        varB4EAC82CA7396A68D541C85D26508E83_439826085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439826085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.061 -0400", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "D2A6899FA3A8A2174A85CD4F5439AED7")
    public String getSpecificationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_215095579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_215095579 = specTitle;
        varB4EAC82CA7396A68D541C85D26508E83_215095579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_215095579;
        // ---------- Original Method ----------
        //return specTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.064 -0400", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "A5D80F7EF99F4FBBE907ACCC2C19ECF1")
    public String getSpecificationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_694520356 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_694520356 = specVendor;
        varB4EAC82CA7396A68D541C85D26508E83_694520356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_694520356;
        // ---------- Original Method ----------
        //return specVendor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.064 -0400", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "50726F72938CCD0CA85208E399B1D948")
    public String getSpecificationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_2062579561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2062579561 = specVersion;
        varB4EAC82CA7396A68D541C85D26508E83_2062579561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2062579561;
        // ---------- Original Method ----------
        //return specVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.064 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "ECA7342FEF42CB2F88542BA80425715E")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_1459881306 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546875946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546875946;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.068 -0400", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "11F835CC73FA3D618D7C182AD5FAC7F3")
    public boolean isCompatibleWith(String version) throws NumberFormatException {
        String[] requested;
        requested = version.split("\\.");
        String[] provided;
        provided = specVersion.split("\\.");
        {
            int i;
            i = 0;
            boolean var10D22493B0E3EBBF2ADDBE9CEDE0714A_885401950 = (i < Math.min(requested.length, provided.length));
            {
                int reqNum;
                reqNum = Integer.parseInt(requested[i]);
                int provNum;
                provNum = Integer.parseInt(provided[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581789388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_581789388;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.083 -0400", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "48ED31209EDC630AAF5D5511AC404160")
    public boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8096458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8096458;
        // ---------- Original Method ----------
        //return sealBase != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.084 -0400", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "FE427C08318A090DF368D8DAB94F476C")
    public boolean isSealed(URL url) {
        boolean varACBE1F9FCC34100F410205F440770D39_1880493859 = (sealBase != null && sealBase.sameFile(url));
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429288721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429288721;
        // ---------- Original Method ----------
        //return sealBase != null && sealBase.sameFile(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.084 -0400", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "880DD81C7E3E47FF0527A1D6A9F37894")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1938255920 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1938255920 = "package " + name;
        varB4EAC82CA7396A68D541C85D26508E83_1938255920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938255920;
        // ---------- Original Method ----------
        //return "package " + name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.085 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "603764DDDF55C39C182DF3078A4D0CCC")

    private static Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

