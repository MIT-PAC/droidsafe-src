package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.Set;

import com.google.android.collect.Sets;

public class ClassPathPackageInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.237 -0500", hash_original_field = "718061C0FE229B5B1D34A4F6DEF8B6A1", hash_generated_field = "FD7D781D3D61CDBFBA455DBEB931B016")

    private  ClassPathPackageInfoSource source;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.239 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "F6B0003813ED943179AFC2BDEE98D917")

    private  String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.241 -0500", hash_original_field = "571D8CB44AFEF3BD2AD07F8D5F4B7648", hash_generated_field = "0756FB1F17FB583BB93EBF5BAB31DF72")

    private  Set<String> subpackageNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.244 -0500", hash_original_field = "E42F1D37D53112734EDD37665E8291DB", hash_generated_field = "98C0CF7268260CD08A966F358E1BB5B8")

    private  Set<Class<?>> topLevelClasses;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.246 -0500", hash_original_method = "C2B7BF925F35B78A73D6EB6850229FDC", hash_generated_method = "C2B7BF925F35B78A73D6EB6850229FDC")
    
ClassPathPackageInfo(ClassPathPackageInfoSource source, String packageName,
            Set<String> subpackageNames, Set<Class<?>> topLevelClasses) {
        this.source = source;
        this.packageName = packageName;
        this.subpackageNames = Collections.unmodifiableSet(subpackageNames);
        this.topLevelClasses = Collections.unmodifiableSet(topLevelClasses);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.248 -0500", hash_original_method = "0CAB032DBD6DBC54FDA0E214BD99EB68", hash_generated_method = "5C22323DA22A6C1F4BDA734E27537E13")
    
public Set<ClassPathPackageInfo> getSubpackages() {
        Set<ClassPathPackageInfo> info = Sets.newHashSet();
        for (String name : subpackageNames) {
            info.add(source.getPackageInfo(name));
        }
        return info;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.250 -0500", hash_original_method = "5916AD531DF76F5F9BA9223D4AB975F5", hash_generated_method = "A8794559579FCE6948CFF1BAA1AA9055")
    
public Set<Class<?>> getTopLevelClassesRecursive() {
        Set<Class<?>> set = Sets.newHashSet();
        addTopLevelClassesTo(set);
        return set;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.253 -0500", hash_original_method = "0BDCB6DD30A5E7EF4568BA987D7AB3D6", hash_generated_method = "9FD84F3351D38B7A09B31A0F43BC7810")
    
private void addTopLevelClassesTo(Set<Class<?>> set) {
        set.addAll(topLevelClasses);
        for (ClassPathPackageInfo info : getSubpackages()) {
            info.addTopLevelClassesTo(set);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.256 -0500", hash_original_method = "CCAFDBCE1F7EFB06EFE401B73EBC24DB", hash_generated_method = "20714EA5E08211D39A33F42067740A11")
    
@Override
    public boolean equals(Object obj) {
        if (obj instanceof ClassPathPackageInfo) {
            ClassPathPackageInfo that = (ClassPathPackageInfo) obj;
            return (this.packageName).equals(that.packageName);
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.259 -0500", hash_original_method = "97236FFE62438E7BA5668D1EFAC10502", hash_generated_method = "A4E7983C761642B928975DFDD712C839")
    
@Override
    public int hashCode() {
        return packageName.hashCode();
    }
    
}

