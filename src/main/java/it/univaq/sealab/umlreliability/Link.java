package it.univaq.sealab.umlreliability;

import org.eclipse.uml2.uml.CommunicationPath;

public class Link {

	private CommunicationPath element;
	private double failureProb;
	private double msgSize = 0.0;
	
	public Link(CommunicationPath element) {
		this.element = element;
	}

	public CommunicationPath getElement() {
		return element;
	}

	public void setElement(CommunicationPath element) {
		this.element = element;
	}

	public double getFailureProb() {
		return failureProb;
	}

	public void setFailureProb(double failureProb) {
		this.failureProb = failureProb;
	}

	public double getMsgSize() {
		return msgSize;
	}

	public void setMsgSize(double msgSize) {
		this.msgSize = msgSize;
	}
}
