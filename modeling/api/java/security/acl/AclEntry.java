/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security.acl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.Principal;
import java.util.Enumeration;

/**
 * The <i>Access Control List Entry</i> interface definition.
 * <p>
 * An {@code AclEntry} is a list of the {@link Permission}s that are
 *  granted (<i>positive</i>) or denied (<i>negative</i>) to a {@link Principal}.
 */
public interface AclEntry extends Cloneable {

    /**
     * Set the principal for this ACL entry.
     * <p>
     * The principal for an ACL entry can only be set once.
     *
     * @param user
     *            the principal for this ACL entry.
     * @return {@code true} on success, {@code false} if there is a principal already set for
     *         this entry.
     */
    boolean setPrincipal(Principal user);

    /**
     * Returns the principal of this ACL entry.
     *
     * @return the principal of this ACL entry, or null if none is set.
     */
    Principal getPrincipal();

    /**
     * Sets this ACL entry to be <i>negative</i>.
     * <p>
     * The permissions in this ACL entry will be denied to the principal
     * associated with this entry.
     * <p>
     * Note: An ACL entry is <i>positive</i> by default and can only become
     * <i>negative</i> by calling this method.
     */
    void setNegativePermissions();

    /**
     * Returns whether this ACL entry is <i>negative</i>.
     *
     * @return {@code true} if this ACL entry is negative, {@code false} if it's positive.
     */
    boolean isNegative();

    /**
     * Adds the specified permission to this ACL entry.
     *
     * @param permission
     *            the permission to be added.
     * @return {@code true} if the specified permission is added, {@code false} if the
     *         permission was already in this entry.
     */
    boolean addPermission(Permission permission);

    /**
     * Removes the specified permission from this ACL entry.
     *
     * @param permission
     *            the permission to be removed.
     * @return {@code true} if the permission is removed, {@code false} if the permission was
     *         not in this entry.
     */
    boolean removePermission(Permission permission);

    /**
     * Checks whether the specified permission is in this ACL entry.
     *
     * @param permission
     *            the permission to check.
     * @return {@code true} if the permission is in this entry, otherwise {@code false}.
     */
    boolean checkPermission(Permission permission);

    /**
     * Returns the list of permissions of this ACL entry.
     *
     * @return the list of permissions of this ACL entry,
     */
    Enumeration<Permission> permissions();

    /**
     * Returns the string representation of this ACL entry.
     *
     * @return the string representation of this ACL entry.
     */
    String toString();

    /**
     * Clones this ACL entry instance.
     *
     * @return a copy of this entry.
     */
    Object clone();

}
