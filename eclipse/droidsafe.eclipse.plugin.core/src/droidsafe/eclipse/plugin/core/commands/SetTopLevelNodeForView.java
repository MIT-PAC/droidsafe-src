package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;

import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

public class SetTopLevelNodeForView extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (!HandlerUtil.matchesRadioState(event)) {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;

        String currentState = event.getParameter(RadioState.PARAMETER_ID);
        if (currentState.equals("input_method")) {
          
          droidsafeView.setEntryPointsAsViewTopLevelParents();
        } else if (currentState.equals("output_method")) {
          
          droidsafeView.setApiCallsAsViewTopLevelParents();
        } else if (currentState.equals("code_location")) {
          droidsafeView.setCodeLocationAsViewTopLevelParents();
        }
        // and finally update the current state
        HandlerUtil.updateRadioState(event.getCommand(), currentState);
      }
    }
    return null;
  }

}
