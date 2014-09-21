/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.nio.ByteBuffer;
import java.util.HashMap;

/**
 * {@code SecureClassLoader} represents a {@code ClassLoader} which associates
 * the classes it loads with a code source and provide mechanisms to allow the
 * relevant permissions to be retrieved.
 */
public class SecureClassLoader extends ClassLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.744 -0400", hash_original_field = "96ACCDDB25CA8C949C14944FDF113E10", hash_generated_field = "5AEEF9DE5247CD1DA3548B4951AB4FCC")

    private HashMap<CodeSource, ProtectionDomain> pds = new HashMap<CodeSource, ProtectionDomain>();

    /**
     * Constructs a new instance of {@code SecureClassLoader}. The default
     * parent {@code ClassLoader} is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.744 -0400", hash_original_method = "4B4D46642D8CC55D099820C8C7F949EC", hash_generated_method = "9422B617283CCD33804950F4404EC8ED")
    
protected SecureClassLoader() {
    }

    /**
     * Constructs a new instance of {@code SecureClassLoader} with the specified
     * parent {@code ClassLoader}.
     *
     * @param parent
     *            the parent {@code ClassLoader}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.745 -0400", hash_original_method = "9D746C0AE16D6D5D82FB26506F642408", hash_generated_method = "67B54E2658AB0498BD218AC05B7E63BC")
    
protected SecureClassLoader(ClassLoader parent) {
        super(parent);
    }

    /**
     * Returns the {@code PermissionCollection} for the specified {@code
     * CodeSource}.
     *
     * @param codesource
     *            the code source.
     * @return the {@code PermissionCollection} for the specified {@code
     *         CodeSource}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.745 -0400", hash_original_method = "687B8C8ED2D113CC62A09D76E8EA258D", hash_generated_method = "614A0381599923A00D55C2AF0D904FA5")
    
protected PermissionCollection getPermissions(CodeSource codesource) {
        // Do nothing by default, ProtectionDomain will take care about
        // permissions in dynamic
        return new Permissions();
    }

    /**
     * Constructs a new class from an array of bytes containing a class
     * definition in class file format with an optional {@code CodeSource}.
     *
     * @param name
     *            the name of the new class.
     * @param b
     *            a memory image of a class file.
     * @param off
     *            the start offset in b of the class data.
     * @param len
     *            the length of the class data.
     * @param cs
     *            the {@code CodeSource}, or {@code null}.
     * @return a new class.
     * @throws IndexOutOfBoundsException
     *             if {@code off} or {@code len} are not valid in respect to
     *             {@code b}.
     * @throws ClassFormatError
     *             if the specified data is not valid class data.
     * @throws SecurityException
     *             if the package to which this class is to be added, already
     *             contains classes which were signed by different certificates,
     *             or if the class name begins with "java."
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.746 -0400", hash_original_method = "40E81C2563CEEFA6E4058B73A14AC8A3", hash_generated_method = "CEF3D4B860EB67F4221AC7C66CCB4333")
    
protected final Class<?> defineClass(String name, byte[] b, int off, int len,
            CodeSource cs) {
        return cs == null ? defineClass(name, b, off, len) : defineClass(name,
                b, off, len, getPD(cs));
    }

    /**
     * Constructs a new class from an array of bytes containing a class
     * definition in class file format with an optional {@code CodeSource}.
     *
     * @param name
     *            the name of the new class.
     * @param b
     *            a memory image of a class file.
     * @param cs
     *            the {@code CodeSource}, or {@code null}.
     * @return a new class.
     * @throws ClassFormatError
     *             if the specified data is not valid class data.
     * @throws SecurityException
     *             if the package to which this class is to be added, already
     *             contains classes which were signed by different certificates,
     *             or if the class name begins with "java."
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.747 -0400", hash_original_method = "7247AFD090E75B25728578AC141286D1", hash_generated_method = "31E8433B5F0DC9096CE07BFEE8C0B041")
    
protected final Class<?> defineClass(String name, ByteBuffer b, CodeSource cs) {
        //FIXME 1.5 - remove b.array(), call super.defineClass(,ByteBuffer,)
        // directly
        byte[] data = b.array();
        return cs == null ? defineClass(name, data, 0, data.length)
                : defineClass(name, data, 0, data.length, getPD(cs));
    }

    // Constructs and caches ProtectionDomain for the given CodeSource
    // object.<br>
    // It calls {@link getPermissions()} to get a set of permissions.
    //
    // @param cs CodeSource object
    // @return ProtectionDomain for the passed CodeSource object
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.747 -0400", hash_original_method = "281D0E5C46C64A601A9A047C7C498882", hash_generated_method = "9C807DB20251AE726FD36BEC1FD835F5")
    
private ProtectionDomain getPD(CodeSource cs) {
        if (cs == null) {
            return null;
        }
        // need to cache PDs, otherwise every class from a given CodeSource
        // will have it's own ProtectionDomain, which does not look right.
        ProtectionDomain pd;
        synchronized (pds) {
            if ((pd = pds.get(cs)) != null) {
                return pd;
            }
            PermissionCollection perms = getPermissions(cs);
            pd = new ProtectionDomain(cs, perms, this, null);
            pds.put(cs, pd);
        }
        return pd;
    }
}
