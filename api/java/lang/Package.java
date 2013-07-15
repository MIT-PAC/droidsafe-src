package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMStack;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;

public class Package implements AnnotatedElement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.075 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.075 -0400", hash_original_field = "27BE8418CD2C41085C56252D66167B09", hash_generated_field = "AE81573D9500136C0B4AD5C6FB30BF01")

    private String specTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.076 -0400", hash_original_field = "A9CA5BD4BAA700E88830DCFF7AD67FEB", hash_generated_field = "8AC9ABDDED2DE61D44AD918D71798BCD")

    private String specVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.076 -0400", hash_original_field = "FE58BF3FA67BADE321C76927A734238B", hash_generated_field = "09287EC9275D23DEE889105D11CDB13B")

    private String specVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.076 -0400", hash_original_field = "5431B7E3ED1CCEC2EC752FF853A0F654", hash_generated_field = "85F560479896D7F78D6BB28FAF454380")

    private String implTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.076 -0400", hash_original_field = "B217C1BB739B1B8D51BC51E9C3451F61", hash_generated_field = "D5CDC04B85CD9B13DDD14861DBF2473C")

    private String implVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.076 -0400", hash_original_field = "F360209BFBB0A5D3C28E1276CDA50BFA", hash_generated_field = "3329CC794A5B24A56B07AB39A5F7B7A7")

    private String implVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.077 -0400", hash_original_field = "085A51E53C69361C2CD178128DADFA4D", hash_generated_field = "E6323554A81EBA1D12B93E5F630D84CC")

    private URL sealBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.080 -0400", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "8B54440B05CE69FA7889906BBB357BE1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.081 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "027004FAA33D2D0C014BB569BEAB9661")
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
for(Annotation annotation : getAnnotations())
        {
    if(annotationType.isInstance(annotation))            
            {
A var2A4302F2C71F8CB31F4FBBBA89DC4531_1128937794 =                 (A) annotation;
                var2A4302F2C71F8CB31F4FBBBA89DC4531_1128937794.addTaint(taint);
                return var2A4302F2C71F8CB31F4FBBBA89DC4531_1128937794;
            } //End block
        } //End block
A var540C13E9E156B687226421B24F2DF178_1007992881 =         null;
        var540C13E9E156B687226421B24F2DF178_1007992881.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1007992881;
        // ---------- Original Method ----------
        //for (Annotation annotation : getAnnotations()) {
            //if (annotationType.isInstance(annotation)) {
                //return (A) annotation;
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.081 -0400", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "0C9B14565E49DB9F0A4178D63CE2997E")
    public Annotation[] getAnnotations() {
Annotation[] varDC6E62BDE5B39FEF5193138B49323593_1760185813 =         NO_ANNOTATIONS;
        varDC6E62BDE5B39FEF5193138B49323593_1760185813.addTaint(taint);
        return varDC6E62BDE5B39FEF5193138B49323593_1760185813;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.082 -0400", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "CF8F09DE4469DBB4DC8033403780D914")
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varDC6E62BDE5B39FEF5193138B49323593_97860174 =         NO_ANNOTATIONS;
        varDC6E62BDE5B39FEF5193138B49323593_97860174.addTaint(taint);
        return varDC6E62BDE5B39FEF5193138B49323593_97860174;
        // ---------- Original Method ----------
        //return NO_ANNOTATIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.082 -0400", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "BDF76D1856FE11EFE4E7EB98C3C0693C")
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        boolean var746CFBDC6E8D19336861A36FB5BAAD13_685856645 = (getAnnotation(annotationType) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320665375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_320665375;
        // ---------- Original Method ----------
        //return getAnnotation(annotationType) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.082 -0400", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "D85CE78F503BFA59B6843F2324AF252F")
    public String getImplementationTitle() {
String var987627F01148D77BADCA0D5358DA0D98_1155521737 =         implTitle;
        var987627F01148D77BADCA0D5358DA0D98_1155521737.addTaint(taint);
        return var987627F01148D77BADCA0D5358DA0D98_1155521737;
        // ---------- Original Method ----------
        //return implTitle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.083 -0400", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "194CF91AEEC2A6325C170C28B4331E0B")
    public String getImplementationVendor() {
String varC318CD996EF1093C3085AD0D9419AF3E_1493260958 =         implVendor;
        varC318CD996EF1093C3085AD0D9419AF3E_1493260958.addTaint(taint);
        return varC318CD996EF1093C3085AD0D9419AF3E_1493260958;
        // ---------- Original Method ----------
        //return implVendor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.083 -0400", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "6A7EEB9B7CCA7A2787935A0B1BB551E8")
    public String getImplementationVersion() {
String varED1B7BCD5067F40382330914AA00FD5C_1874848181 =         implVersion;
        varED1B7BCD5067F40382330914AA00FD5C_1874848181.addTaint(taint);
        return varED1B7BCD5067F40382330914AA00FD5C_1874848181;
        // ---------- Original Method ----------
        //return implVersion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.084 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "2895C3B0894DEC42A526D4FF0DA313F4")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1159698167 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1159698167.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1159698167;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.085 -0400", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "A82BA8D7DBBDA6814C8B68232B290274")
    public String getSpecificationTitle() {
String var54663AAE14CC50F01F40B7B409184D90_681204388 =         specTitle;
        var54663AAE14CC50F01F40B7B409184D90_681204388.addTaint(taint);
        return var54663AAE14CC50F01F40B7B409184D90_681204388;
        // ---------- Original Method ----------
        //return specTitle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.085 -0400", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "DFF485B113E05659C6690E95FD442F6F")
    public String getSpecificationVendor() {
String varCC36E46C3BF28E375BAEBEAA072DA78E_462834729 =         specVendor;
        varCC36E46C3BF28E375BAEBEAA072DA78E_462834729.addTaint(taint);
        return varCC36E46C3BF28E375BAEBEAA072DA78E_462834729;
        // ---------- Original Method ----------
        //return specVendor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.085 -0400", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "D418B727298AE595C876CA5A5CD13233")
    public String getSpecificationVersion() {
String varCC86E07485E22F7CD8BAC1F10478C5CB_1726920716 =         specVersion;
        varCC86E07485E22F7CD8BAC1F10478C5CB_1726920716.addTaint(taint);
        return varCC86E07485E22F7CD8BAC1F10478C5CB_1726920716;
        // ---------- Original Method ----------
        //return specVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.086 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "39349CA63EE077088F2EF9A63A26C95B")
    @Override
    public int hashCode() {
        int var5715838B66EDF423F24A871806972EB3_1535779094 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780323587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780323587;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.088 -0400", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "8341645A13BC6FF892434AE6DD9C1C67")
    public boolean isCompatibleWith(String version) throws NumberFormatException {
        addTaint(version.getTaint());
        String[] requested = version.split("\\.");
        String[] provided = specVersion.split("\\.");
for(int i = 0;i < Math.min(requested.length, provided.length);i++)
        {
            int reqNum = Integer.parseInt(requested[i]);
            int provNum = Integer.parseInt(provided[i]);
    if(reqNum > provNum)            
            {
                boolean var68934A3E9455FA72420237EB05902327_910248801 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667736342 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667736342;
            } //End block
            else
    if(reqNum < provNum)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1520894373 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530607876 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_530607876;
            } //End block
        } //End block
    if(requested.length > provided.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_312752018 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041257783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041257783;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1378588536 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614154377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614154377;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.091 -0400", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "15E748D26D0306A496FB92500119A80F")
    public boolean isSealed() {
        boolean var4E8C5FF1604C87C031D8B57727789352_1809296354 = (sealBase != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696412979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_696412979;
        // ---------- Original Method ----------
        //return sealBase != null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.093 -0400", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "11FBB290B2F7F60AE3EDBCD127BB2887")
    public boolean isSealed(URL url) {
        addTaint(url.getTaint());
        boolean var9A3D7F81A12BCF6076EE4F498F55AE67_456315831 = (sealBase != null && sealBase.sameFile(url));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1497856188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1497856188;
        // ---------- Original Method ----------
        //return sealBase != null && sealBase.sameFile(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.095 -0400", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "3D1A433CB8679917290009A0B51C1918")
    @Override
    public String toString() {
String varF0E3CDE2E0DBDD70A38F5177DA4D6F24_1102608381 =         "package " + name;
        varF0E3CDE2E0DBDD70A38F5177DA4D6F24_1102608381.addTaint(taint);
        return varF0E3CDE2E0DBDD70A38F5177DA4D6F24_1102608381;
        // ---------- Original Method ----------
        //return "package " + name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.095 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

