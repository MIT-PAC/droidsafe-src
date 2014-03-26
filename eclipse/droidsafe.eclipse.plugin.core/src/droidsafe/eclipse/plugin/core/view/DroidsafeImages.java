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

    /** The image for a method receiver node in the points-to outline view */
    public static final Image METHOD_RECEIVER_IMAGE = DroidsafePluginUtilities.getImage("meth-receiver.png");

    /** The image for a method argument node in the points-to outline view */
    public static final Image METHOD_ARG_IMAGE = DroidsafePluginUtilities.getImage("meth-arg.png");

    /** The image for an allocation node in the points-to outline view */
    public static final Image ALLOC_NODE_IMAGE = DroidsafePluginUtilities.getImage("pointsto.png");

    /** The image for a call edge in the points-to outline view */
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

}
