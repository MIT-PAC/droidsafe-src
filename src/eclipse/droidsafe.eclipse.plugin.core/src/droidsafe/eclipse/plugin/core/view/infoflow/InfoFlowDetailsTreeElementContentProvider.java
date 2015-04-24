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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import droidsafe.android.system.API;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowDetailsTreeElementContentProvider extends MethodInfoTreeElementContentProvider {

    /**
     * Populate the tree elements of the info flow outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        MethodModel method = null;
        String sourceFilter = null;
        String sinkFilter = null;
        if (fInput instanceof MethodModel) {
            method = (MethodModel) fInput;
        } else if (fInput instanceof MethodWithSourceSinkFilter) {
            MethodWithSourceSinkFilter methodWithSourceSinkFilter = (MethodWithSourceSinkFilter) fInput;
            method = methodWithSourceSinkFilter.getMethod();
            SourceSinkPair sourceSinkFilter = methodWithSourceSinkFilter.getSourceSinkFilter();
            sourceFilter = sourceSinkFilter.getO1();
            sinkFilter = sourceSinkFilter.getO2();
        }
        if (!method.hasInfoFlowInfo())
            return NO_CHILDREN;
        List<Object> roots = new ArrayList<Object>();
        boolean hasSourceInfo = false;
        TreeElement<String, MethodArgumentModel> sourceRoot =
                new TreeElement<String, MethodArgumentModel>("Sources", "Sources", MethodArgumentModel.class);
        for (int i = -1; i < method.getMethodArguments().size(); i++) {
            MethodArgumentModel methodArg = method.getArgumentModel(i);
            Map<String, List<CallLocationModel>> infoKindToCalls = methodArg.getSourceInfoUnits();
            if (infoKindToCalls != null && !infoKindToCalls.isEmpty()) {
                Set<String> infoKinds = infoKindToCalls.keySet();
                if (sourceFilter == null || infoKinds.contains(sourceFilter)) {
                    if (sourceFilter != null) {
                        infoKinds = new HashSet<String>();
                        infoKinds.add(sourceFilter);
                    }
                    hasSourceInfo = true;
                    TreeElement<MethodArgumentModel, String> methArgElement =
                            new TreeElement<MethodArgumentModel, String>(methodArg.toString(),
                                    methodArg, String.class);
                    for (String infoKind: infoKinds) {
                        TreeElement<String, CallLocationModel> infoKindElement = new TreeElement<String, CallLocationModel>(infoKind, infoKind, CallLocationModel.class);
                        methArgElement.addChild(infoKindElement);
                        List<CallLocationModel> locs = infoKindToCalls.get(infoKind);
                        if (locs != null) {
                            for (CallLocationModel loc: locs) {
                                TreeElement<CallLocationModel, Object> locElement = new TreeElement<CallLocationModel, Object>(loc.toString(), loc, Object.class);
                                infoKindElement.addChild(locElement);
                            }
                        }
                    }
                    sourceRoot.addChild(methArgElement);
                }
            }
        }
        if (hasSourceInfo)
            roots.add(sourceRoot);
        List<String> sinkInfoKinds = method.getSinkInfoKinds();
        if (sinkInfoKinds != null) {
            TreeElement<String, String> sinkRoot =
                    new TreeElement<String, String>("Sinks", "Sinks", String.class);
            String infoKindsStr = (sinkFilter != null) ? sinkFilter : sinkInfoKinds.toString();
            TreeElement<String, Object> infoKindsElement = new TreeElement<String, Object>(infoKindsStr, infoKindsStr, Object.class);
            sinkRoot.addChild(infoKindsElement);
            roots.add(sinkRoot);
        }
        return roots.toArray();
    }

}
