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

/**
 * Represents a pair of source kind and sink kind.
 * @author gilham
 *
 */
public class SourceSinkPair extends Pair<String, String>{

    /**
     * Constructs a SourceSinkPair.
     * 
     * @param source - a source kind
     * @param sink - a sink kind
     */
    public SourceSinkPair(String source, String sink) {
        super(source, sink);
    }

    @Override
    public String toString() {
        return getO1() + "->" + getO2();
    }

}
