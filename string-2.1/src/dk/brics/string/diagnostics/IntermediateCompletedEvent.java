package dk.brics.string.diagnostics;

import java.util.Set;

import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.operations.AliasAnalysis;
import dk.brics.string.intermediate.operations.OperationAssertionAnalysis;
import dk.brics.string.intermediate.operations.LivenessAnalysis;
import dk.brics.string.intermediate.operations.ReachingDefinitions;

/**
 * Contains information about the intermediate representation. This is a "parameter object",
 * so the signature to {@link DiagnosticsStrategy#intermediateCompleted} does not change when we add more information here.
 */
public class IntermediateCompletedEvent {
	private Application application;
	private LivenessAnalysis liveness;
	private AliasAnalysis alias;
	private ReachingDefinitions reachingDefinitions;
	private OperationAssertionAnalysis assertions;
	private Set<Statement> hotspots;

	public IntermediateCompletedEvent(Application application,
            LivenessAnalysis liveness, AliasAnalysis alias,
            ReachingDefinitions reaching, OperationAssertionAnalysis assertions,
            Set<Statement> hotspots) {
        this.application = application;
        this.liveness = liveness;
        this.alias = alias;
        this.reachingDefinitions = reaching;
        this.assertions = assertions;
        this.hotspots = hotspots;
    }

    public Application getApplication() {
		return application;
	}

	public LivenessAnalysis getLiveness() {
		return liveness;
	}

	public AliasAnalysis getAlias() {
		return alias;
	}

	public ReachingDefinitions getReachingDefinitions() {
		return reachingDefinitions;
	}

	public Set<Statement> getHotspots() {
		return hotspots;
	}

    public OperationAssertionAnalysis getAssertions() {
        return assertions;
    }
	
	
}