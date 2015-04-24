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

package droidsafe.eclipse.plugin.core.view;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public class DroidsafeImages {

    /** The image for the method node in the outline view */
    public static final Image SAFE_ANDROID_IMAGE = DroidsafePluginUtilities.getImage("android.png");

    /** The image for the unsafe method node in the outline view */
    public static final Image UNSAFE_ANDROID_IMAGE = DroidsafePluginUtilities.getImage("red-android.png");

    /** The image for the method node with info flow in the outline view */
    public static final Image SAFE_ANDROID_WITH_INFO_IMAGE = DroidsafePluginUtilities.getImage("android-with-info.png");

    /** The image for the unsafe method node with info flow in the outline view */
    public static final Image UNSAFE_ANDROID_WITH_INFO_IMAGE = DroidsafePluginUtilities.getImage("red-android-with-info.png");

    /** Image for Hotspot Nodes */
  //  public static final Image HOTSPOT_IMAGE = DroidsafePluginUtilities.getImage("hotspot.png");

    /** The image for whitelist entry in the outline view */
    public static final Image DEFAULT_IMAGE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_OBJ_FOLDER);

    /** The image to use for safe code locations */
    public static final Image SAFE_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
        .getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJS_TASK_TSK);

    /** Image for unresolved code locations */
    public static final Image UNRESOLVED_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
        .getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

    /** Image for unsafe code locations */
    public static final Image UNSAFE_SOURCE_LOCATION_IMAGE = PlatformUI.getWorkbench()
        .getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);

    /** The image for a method receiver node in the droidsafe outline view */
    public static final Image METHOD_RECEIVER_IMAGE = DroidsafePluginUtilities.getImage("meth-receiver.png");

    /** The image for a method argument node in the droidsafe outline view */
    public static final Image METHOD_ARG_IMAGE = DroidsafePluginUtilities.getImage("meth-arg.png");

    /** The image for an allocation node in the droidsafe outline view */
    public static final Image ALLOC_NODE_IMAGE = DroidsafePluginUtilities.getImage("pointsto.png");

    /** The image for a call edge in the droidsafe outline view */
    public static final Image CODE_LOC_IMAGE = DroidsafePluginUtilities.getImage("change.png");

    /** The image for a source info kind in the info flow outline view */
    public static final Image SOURCE_IMAGE = DroidsafePluginUtilities.getImage("source.png");

    /** The image for a source info kind in the info flow outline view */
    public static final Image SINK_IMAGE = DroidsafePluginUtilities.getImage("sink.png");

    /** The image for the indicator of the existence of info flow */
    public static final Image INFO_FLOW_IMAGE = DroidsafePluginUtilities.getImage("info-flow.png");

    /** The image for a checked box */
    public static final Image CHECKED = DroidsafePluginUtilities.getImage("checked.gif");

    /** The image for an unchecked box */
    public static final Image UNCHECKED = DroidsafePluginUtilities.getImage("unchecked.gif");

    /** The image for a down arrow */
    public static final Image NEXT_IMAGE = DroidsafePluginUtilities.getImage("next.png");

    /** The image for an up arrow */
    public static final Image PREV_IMAGE = DroidsafePluginUtilities.getImage("prev.png");

    /** The image for closing a view */
    public static final Image CLOSE_IMAGE = DroidsafePluginUtilities.getImage("close.gif");

}
