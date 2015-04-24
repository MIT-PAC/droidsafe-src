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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SpecInfoTreeElementContentProvider;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Content provider for the tree structure of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowSummaryTreeElementContentProvider extends SpecInfoTreeElementContentProvider {

    /**
     * Populate the tree elements of the info flow outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
      Map<String, Map<String, Set<MethodModel>>> infoFlowSummaryMap = getSpec().getInfoFlowSummaryMap();
        if (infoFlowSummaryMap.isEmpty())
            return NO_CHILDREN;
        List<Object> roots = new ArrayList<Object>();
        for (String source : infoFlowSummaryMap.keySet()) {
            Map<String, Set<MethodModel>> sinkMap = infoFlowSummaryMap.get(source);
            for (String sink : sinkMap.keySet()) {
                SourceSinkPair sourceSinkPair = new SourceSinkPair(source, sink);
                TreeElement<SourceSinkPair, MethodModel> root =
                        new TreeElement<SourceSinkPair, MethodModel>(sourceSinkPair.toString(), sourceSinkPair, MethodModel.class);
                Set<MethodModel> methods = sinkMap.get(sink);
                for (MethodModel method: methods) {
                    TreeElement<MethodModel, Object> methElement =
                            new TreeElement<MethodModel, Object>(method.toString(), method, Object.class);
                    root.addChild(methElement);
                }
                roots.add(root);
            }
        }
        return roots.toArray();
    }

}