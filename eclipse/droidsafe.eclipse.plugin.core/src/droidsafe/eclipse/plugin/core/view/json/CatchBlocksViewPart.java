package droidsafe.eclipse.plugin.core.view.json;

public class CatchBlocksViewPart extends JsonViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.CatchBlocksView";

    /**
     * Open the outline view for the given input element.
     */
    public static void openView() {
        JsonViewPart.openView("catch_blocks.json", VIEW_ID);
    }

    protected void projectChanged() {
        openView(); 
    }

}
