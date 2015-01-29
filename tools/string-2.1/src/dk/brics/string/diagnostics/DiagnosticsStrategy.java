package dk.brics.string.diagnostics;


import dk.brics.string.StringAnalysis;
import dk.brics.string.flow.FlowGraph;

/**
 * Receives notifications of the progress in {@link StringAnalysis}. A diagnostics strategy
 * should not affect the results of the analysis in any way.
 */
public interface DiagnosticsStrategy {
	/**
	 * Called when the analysis is about to start.
	 */
	void analysisStarted();
	
	/**
	 * Called when the intermediate representation and liveness, alias, and reaching definitions analysis of it
	 * is complete. The arguments must not be modified.
	 * @param event contains the relevant information for the event.
	 */
	void intermediateCompleted(IntermediateCompletedEvent event);
	
	/**
	 * Called when the flow graph has been completed.
	 * @param graph the flow graph. Must not be modified.
	 */
	void flowGraphCompleted(FlowGraph graph);
}
