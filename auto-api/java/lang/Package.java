package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.VMStack;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;

public class Package implements AnnotatedElement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "27BE8418CD2C41085C56252D66167B09", hash_generated_field = "AE81573D9500136C0B4AD5C6FB30BF01")

    private String specTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "A9CA5BD4BAA700E88830DCFF7AD67FEB", hash_generated_field = "8AC9ABDDED2DE61D44AD918D71798BCD")

    private String specVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "FE58BF3FA67BADE321C76927A734238B", hash_generated_field = "09287EC9275D23DEE889105D11CDB13B")

    private String specVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "5431B7E3ED1CCEC2EC752FF853A0F654", hash_generated_field = "85F560479896D7F78D6BB28FAF454380")

    private String implTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "B217C1BB739B1B8D51BC51E9C3451F61", hash_generated_field = "D5CDC04B85CD9B13DDD14861DBF2473C")

    private String implVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "F360209BFBB0A5D3C28E1276CDA50BFA", hash_generated_field = "3329CC794A5B24A56B07AB39A5F7B7A7")

    private String implVendor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.445 -0400", hash_original_field = "085A51E53C69361C2CD178128DADFA4D", hash_generated_field = "E6323554A81EBA1D12B93E5F630D84CC")

    private URL sealBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.446 -0400", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "8B54440B05CE69FA7889906BBB357BE1")
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
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.449 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "FD29867A6275D64C91D9CD5BC8B8B7B1")
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_232825850 = null; 
        A varB4EAC82CA7396A68D541C85D26508E83_112426670 = null; 
        {
            Annotation annotation = getAnnotations()[0];
            {
                {
                    boolean var7B7B6346786911875D9C711693128818_236406201 = (annotationType.isInstance(annotation));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_232825850 = (A) annotation;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_112426670 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_1646631310; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1646631310 = varB4EAC82CA7396A68D541C85D26508E83_232825850;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1646631310 = varB4EAC82CA7396A68D541C85D26508E83_112426670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1646631310.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1646631310;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.450 -0400", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "1C6142FF750419C00E238E48688BA999")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_734658730 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_734658730 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_734658730.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_734658730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.450 -0400", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "D9C49E96E4FA91D5247A14E35E215400")
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_391911666 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_391911666 = NO_ANNOTATIONS;
        varB4EAC82CA7396A68D541C85D26508E83_391911666.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_391911666;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.450 -0400", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "62FD6643FFFC0DE99F32FFFA452B141A")
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        boolean varDDEB039E2721937655C903B84DC79D17_1403013989 = (getAnnotation(annotationType) != null);
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223718005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223718005;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.451 -0400", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "ABE7029A559A42F08F0D4BFA620A534B")
    public String getImplementationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_194439847 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_194439847 = implTitle;
        varB4EAC82CA7396A68D541C85D26508E83_194439847.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_194439847;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.451 -0400", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "FA620FA546B7FE3C11B725C7695CADE2")
    public String getImplementationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1834794116 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1834794116 = implVendor;
        varB4EAC82CA7396A68D541C85D26508E83_1834794116.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1834794116;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.452 -0400", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "475268505934EC6AEFA8CB9840B8F332")
    public String getImplementationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_282417615 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_282417615 = implVersion;
        varB4EAC82CA7396A68D541C85D26508E83_282417615.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_282417615;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.452 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "4FACB75E7A1E93675AF9F5974A576058")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_311465320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_311465320 = name;
        varB4EAC82CA7396A68D541C85D26508E83_311465320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_311465320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Package getPackage(String packageName) {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackage(packageName);
    }

    
    @DSModeled(DSC.SAFE)
    public static Package[] getPackages() {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.453 -0400", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "B559CE229B8E722E8C83C57A6A3C5854")
    public String getSpecificationTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_905812805 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_905812805 = specTitle;
        varB4EAC82CA7396A68D541C85D26508E83_905812805.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_905812805;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.454 -0400", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "5B994E775DA4B9E3A311E9B64F29B308")
    public String getSpecificationVendor() {
        String varB4EAC82CA7396A68D541C85D26508E83_787940961 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_787940961 = specVendor;
        varB4EAC82CA7396A68D541C85D26508E83_787940961.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_787940961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.454 -0400", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "7F2A8E1C2BFF0F74A04E960A040B131B")
    public String getSpecificationVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_881657596 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_881657596 = specVersion;
        varB4EAC82CA7396A68D541C85D26508E83_881657596.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_881657596;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.454 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "C7465926DFDB5B0669EA6B45861CB78E")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_2038904679 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015133247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015133247;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.455 -0400", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "8D4A3BF88168736F3A470C51F8A1E28C")
    public boolean isCompatibleWith(String version) throws NumberFormatException {
        String[] requested = version.split("\\.");
        String[] provided = specVersion.split("\\.");
        {
            int i = 0;
            boolean var10D22493B0E3EBBF2ADDBE9CEDE0714A_1801263164 = (i < Math.min(requested.length, provided.length));
            {
                int reqNum = Integer.parseInt(requested[i]);
                int provNum = Integer.parseInt(provided[i]);
            } 
        } 
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138267020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138267020;
        
        
        
        
            
            
            
                
            
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.455 -0400", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "5C280C56CF87A7E77EEB403D3CC50F65")
    public boolean isSealed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598034063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598034063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.456 -0400", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "59E2464E7F8E88EE1587FB716F543AA9")
    public boolean isSealed(URL url) {
        boolean varACBE1F9FCC34100F410205F440770D39_75412424 = (sealBase != null && sealBase.sameFile(url));
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719359899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719359899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.456 -0400", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "690DA98F2329619931D4D254DBE744DD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2057568661 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2057568661 = "package " + name;
        varB4EAC82CA7396A68D541C85D26508E83_2057568661.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2057568661;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.456 -0400", hash_original_field = "34D6D6954DE3EDD110F2D639DA598DA0", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
}

