package it.univaq.sealab.umlreliability;

import java.util.List;

import it.univaq.sealab.umlreliability.elements.Component;
import it.univaq.sealab.umlreliability.elements.Link;
import it.univaq.sealab.umlreliability.elements.Scenario;

public class Reliability {

	private List<Scenario> scenarios;
	private List<Component> components;
	private List<Link> links;
	
	public Reliability(final List<Scenario> scenarios, final List<Component> components, final List<Link> links) {
		this.scenarios = scenarios;
		this.components = components;
		this.links = links;
	}
	
	public double compute() {
		double firstTerm = 0;
		double secondTerm = 1;
		double thirdTerm = 1;
		
		for (Scenario scenario : scenarios) {
			firstTerm += scenario.getFailureProb();
			for (Component component : components) {
				secondTerm *= Math.pow(1 - component.getFailureProb(), component.getInvocations().getOrDefault(scenario, 0));
				for (Link link : links) {
					thirdTerm *= Math.pow(1 - link.getFailureProb(), link.getMsgSize());
				}
			}
		}
		
		return 1 - firstTerm * (secondTerm * thirdTerm);
	}

	/**
	 * 
	 * @param scenariosProbs - p_j
	 * @param componentsFailProbs - theta_j
	 * @param componentsInvocations - InvNr_ij
	 * @param linkFailProbs - psi_lij
	 * @param msgSize - MsgSize(l,i)
	 *
	public double compute() {
		double firstTerm = 0;
		double secondTerm = 1;
		double thirdTerm = 1;
		
		// j = scenarios
		for (int j = 0; j < scenariosProbs.length; j++) {
			firstTerm += scenariosProbs[j];
			// i = components
			for (int i = 0; i < componentsFailProbs.length; i++) {
				secondTerm *= Math.pow(1 - componentsFailProbs[i], componentsInvocations[j][i]);
				// l = links
				for (int l = 0; l < linkFailProbs.length; l++) {
					thirdTerm *= Math.pow(1 - linkFailProbs[l], msgSize[l]);
				}
			}
		}
	
		return 1 - firstTerm * (secondTerm * thirdTerm);
	}
	*/
}
