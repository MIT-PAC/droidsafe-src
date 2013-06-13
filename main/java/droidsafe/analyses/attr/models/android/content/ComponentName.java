/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package droidsafe.analyses.attr.models.android.content;

import com.google.common.collect.Sets;

import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.models.android.content.Context;

import java.lang.Comparable;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * Identifier for a specific application component
 * ({@link android.app.Activity}, {@link android.app.Service},
 * {@link android.content.BroadcastReceiver}, or
 * {@link android.content.ContentProvider}) that is available.  Two
 * pieces of information, encapsulated here, are required to identify
 * a component: the package (a String) it exists in, and the class (a String)
 * name inside of that package.
 * 
 * @author dpetters
 */

public final class ComponentName extends AttrModeledClass {

    private Set<String> mPackage;
    private Set<String> mClass;

    public ComponentName(AllocNode allocNode) {
        super(allocNode);
    }

    /**
     * Create a new component identifier.
     * 
     * @param pkg The name of the package that the component exists in.  Can
     * not be null.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.  Can not be null.
     */
    public void _init_(Set<String> pkg, Set<String> cls) {
        mPackage = pkg;
        mClass = cls;
    }

    /**
     * Create a new component identifier from a Context and class name.
     * 
     * @param pkg A Context for the package implementing the component,
     * from which the actual package name will be retrieved.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.
     */
    public void _init_(Context pkg, Set<String> cls) {
        mPackage = pkg.getPackageName();
        mClass = cls;
    }

    /**
     * Create a new component identifier from a Context and Class object.
     * 
     * @param pkg A Context for the package implementing the component, from
     * which the actual package name will be retrieved.
     * @param cls The Class object of the desired component, from which the
     * actual class name will be retrieved.
     */
    public void _init_(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = Sets.newHashSet(new String(cls.getName()));
    }
    
    // need this - called in Intent model
    public ComponentName(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = Sets.newHashSet(new String(cls.getName()));
    }

    /**
     * Return the package name of this component.
     */
    public Set<String> getPackageName() {
        return mPackage;
    }

    /**
     * Return the class name of this component.
     */
    public Set<String> getClassName() {
        return mClass;
    }
}
