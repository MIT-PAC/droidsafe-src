package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.google.android.collect.Sets;
import java.util.Collections;
import java.util.Set;

public class ClassPathPackageInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.819 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "FD7D781D3D61CDBFBA455DBEB931B016")

    private ClassPathPackageInfoSource source;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.819 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "F6B0003813ED943179AFC2BDEE98D917")

    private String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.819 -0400", hash_original_field = "B91DE9D0DC5B63B367A70356077DF474", hash_generated_field = "0756FB1F17FB583BB93EBF5BAB31DF72")

    private Set<String> subpackageNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.819 -0400", hash_original_field = "8CE852235D86F3FAC34D08528D658E0A", hash_generated_field = "98C0CF7268260CD08A966F358E1BB5B8")

    private Set<Class<?>> topLevelClasses;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.820 -0400", hash_original_method = "C2B7BF925F35B78A73D6EB6850229FDC", hash_generated_method = "B3170EB32827428CED92393F728E38EC")
      ClassPathPackageInfo(ClassPathPackageInfoSource source, String packageName,
            Set<String> subpackageNames, Set<Class<?>> topLevelClasses) {
        this.source = source;
        this.packageName = packageName;
        this.subpackageNames = Collections.unmodifiableSet(subpackageNames);
        this.topLevelClasses = Collections.unmodifiableSet(topLevelClasses);
        // ---------- Original Method ----------
        //this.source = source;
        //this.packageName = packageName;
        //this.subpackageNames = Collections.unmodifiableSet(subpackageNames);
        //this.topLevelClasses = Collections.unmodifiableSet(topLevelClasses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.820 -0400", hash_original_method = "0CAB032DBD6DBC54FDA0E214BD99EB68", hash_generated_method = "BFF2A9C09CF5D7108FE41B7464059228")
    public Set<ClassPathPackageInfo> getSubpackages() {
        Set<ClassPathPackageInfo> info = Sets.newHashSet();
for(String name : subpackageNames)
        {
            info.add(source.getPackageInfo(name));
        } //End block
Set<ClassPathPackageInfo> var43CF3338FDBA93597A9562D3166E9DC4_187823201 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_187823201.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_187823201;
        // ---------- Original Method ----------
        //Set<ClassPathPackageInfo> info = Sets.newHashSet();
        //for (String name : subpackageNames) {
            //info.add(source.getPackageInfo(name));
        //}
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.821 -0400", hash_original_method = "5916AD531DF76F5F9BA9223D4AB975F5", hash_generated_method = "2160A423B7CE68C8494CC518C2CF1D9D")
    public Set<Class<?>> getTopLevelClassesRecursive() {
        Set<Class<?>> set = Sets.newHashSet();
        addTopLevelClassesTo(set);
Set<Class<?>> varD2D4612E029977363A9BBEBD4F0339C0_953481393 =         set;
        varD2D4612E029977363A9BBEBD4F0339C0_953481393.addTaint(taint);
        return varD2D4612E029977363A9BBEBD4F0339C0_953481393;
        // ---------- Original Method ----------
        //Set<Class<?>> set = Sets.newHashSet();
        //addTopLevelClassesTo(set);
        //return set;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.821 -0400", hash_original_method = "0BDCB6DD30A5E7EF4568BA987D7AB3D6", hash_generated_method = "277039752B920F89D35C56BA67C17A49")
    private void addTopLevelClassesTo(Set<Class<?>> set) {
        addTaint(set.getTaint());
        set.addAll(topLevelClasses);
for(ClassPathPackageInfo info : getSubpackages())
        {
            info.addTopLevelClassesTo(set);
        } //End block
        // ---------- Original Method ----------
        //set.addAll(topLevelClasses);
        //for (ClassPathPackageInfo info : getSubpackages()) {
            //info.addTopLevelClassesTo(set);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.821 -0400", hash_original_method = "CCAFDBCE1F7EFB06EFE401B73EBC24DB", hash_generated_method = "F88CEE30E7CB69C1BC65C93E9943EE9D")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof ClassPathPackageInfo)        
        {
            ClassPathPackageInfo that = (ClassPathPackageInfo) obj;
            boolean var5E0080B4A99534A09F796FC574CD1748_1933625569 = ((this.packageName).equals(that.packageName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748830139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748830139;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1469457406 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949583094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949583094;
        // ---------- Original Method ----------
        //if (obj instanceof ClassPathPackageInfo) {
            //ClassPathPackageInfo that = (ClassPathPackageInfo) obj;
            //return (this.packageName).equals(that.packageName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.822 -0400", hash_original_method = "97236FFE62438E7BA5668D1EFAC10502", hash_generated_method = "F807D3DFE68AFFCEA7A47C9EB35303E1")
    @Override
    public int hashCode() {
        int var38876AF18AE7BA34925A37FE98024E05_807766188 = (packageName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131976627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131976627;
        // ---------- Original Method ----------
        //return packageName.hashCode();
    }

    
}

