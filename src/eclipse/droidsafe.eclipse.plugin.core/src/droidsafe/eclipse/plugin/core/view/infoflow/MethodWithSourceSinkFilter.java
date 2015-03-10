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
 */

package droidsafe.eclipse.plugin.core.view.infoflow;

import soot.toolkits.scalar.Pair;
import droidsafe.speclang.model.MethodModel;

/**
 * A pair of a method model and a <source kind, sink kind> filter.
 * 
 * @author gilham
 *
 */
public class MethodWithSourceSinkFilter extends Pair<MethodModel, SourceSinkPair>{

    /**
     * Constructs a MethodWithSourceSinkFilter with the given method and the given
     * <source, sink> filter.
     */
    public MethodWithSourceSinkFilter(MethodModel method, SourceSinkPair sourceSinkFilter) {
        super(method, sourceSinkFilter);
    }
    
    /**
     * Returns the method.
     */
    public MethodModel getMethod() {
        return (MethodModel) getO1();
    }
    
    /**
     * Returns the <source, sink> filter.
     */
    public SourceSinkPair getSourceSinkFilter() {
        return (SourceSinkPair) getO2();
    }
    
}
