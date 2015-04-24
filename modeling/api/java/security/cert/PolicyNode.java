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


package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Iterator;
import java.util.Set;

/**
 * The interface to a valid policy tree node for the PKIX certification path
 * validation algorithm.
 * <p>
 * Instances of this class are one of the outputs of the PKIX certification path
 * validation algorithm.
 */
public interface PolicyNode {

    /**
     * Returns the list of children of this node as an {@code Iterator}.
     *
     * @return the list of children of this node as an {@code Iterator}.
     */
    public Iterator<? extends PolicyNode> getChildren();

    /**
     * Returns the depth of this node in the policy tree.
     * <p>
     * the depth is zero based.
     *
     * @return the depth of this node in the policy tree.
     */
    public int getDepth();

    /**
     * Returns the expected policies for the next certificate to be valid.
     *
     * @return the expected policies.
     */
    public Set<String> getExpectedPolicies();

    /**
     * Returns the parent policy node.
     *
     * @return the parent policy node.
     */
    public PolicyNode getParent();

    /**
     * Returns the policy qualifiers associated with the policy of this node.
     *
     * @return the policy qualifiers associated with the policy of this node.
     */
    public Set<? extends PolicyQualifierInfo> getPolicyQualifiers();

    /**
     * Returns the valid policy of this node.
     *
     * @return the valid policy of this node.
     */
    public String getValidPolicy();

    /**
     * Returns whether the certificate policy extension of the most recently
     * processed certificate is marked as critical.
     *
     * @return {@code true} if the extension is marked as critical, otherwise
     *         {@code false}.
     */
    public boolean isCritical();
}
