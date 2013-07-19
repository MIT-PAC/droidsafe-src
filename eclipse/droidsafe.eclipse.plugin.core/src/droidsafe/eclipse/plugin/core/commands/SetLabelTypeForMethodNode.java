package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;

import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;


/**
 * Command to switch the type of label used to display method nodes in the droidsafe outline view.
 * Parameter value "short_label" will use the short form of the method signature and print argument
 * values, while parameter value "long_value" will print the long form of the signature with fully
 * qualified class names, but no attribute value.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SetLabelTypeForMethodNode extends AbstractHandler {

  /**
   * Command implementation. Retrieves the value of the parameter value, and delegates to the view
   * to set the correct value for the methods labels.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (!HandlerUtil.matchesRadioState(event)) {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
        String currentState = event.getParameter(RadioState.PARAMETER_ID);
        droidsafeView.setLabelTypeForMethodName(currentState);
        // and finally update the current state
        HandlerUtil.updateRadioState(event.getCommand(), currentState);
      }
    }
    return null;
  }

}
