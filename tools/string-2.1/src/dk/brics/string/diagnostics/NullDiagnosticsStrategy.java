package dk.brics.string.diagnostics;


import dk.brics.string.StringAnalysis;
import dk.brics.string.flow.FlowGraph;

/**
 * Diagnostics strategy that does nothing.
 * <p/>
 * This can be used as base class for diagnostics strategies that only want to implement a few event responses.
 * It is also used by {@link StringAnalysis} as the fallback diagnostics in case no strategy was specified.
 */
public class NullDiagnosticsStrategy implements DiagnosticsStrategy {
	
	public void intermediateCompleted(IntermediateCompletedEvent event) {
	}
	
	public void analysisStarted() {
	}

	public void flowGraphCompleted(FlowGraph graph) {
	}
	
}
