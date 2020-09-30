package it.univaq.sealab.umlreliability;

import org.eclipse.uml2.uml.UseCase;

public class Scenario {

	private UseCase element;
	private double failureProb;
	
	Scenario(final UseCase element) {
		this.element = element;
	}

	public UseCase getElement() {
		return element;
	}

	public void setElement(UseCase element) {
		this.element = element;
	}

	public double getFailureProb() {
		return failureProb;
	}

	public void setFailureProb(double failureProb) {
		this.failureProb = failureProb;
	}
}
