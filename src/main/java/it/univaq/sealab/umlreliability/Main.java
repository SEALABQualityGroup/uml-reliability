package it.univaq.sealab.umlreliability;

import java.util.List;

import it.univaq.sealab.umlreliability.elements.Component;
import it.univaq.sealab.umlreliability.elements.Link;
import it.univaq.sealab.umlreliability.elements.Scenario;
import it.univaq.sealab.umlreliability.model.UMLModelPapyrus;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		final UMLReliability uml = new UMLReliability(new UMLModelPapyrus(args[0]).getModel());
		final List<Scenario> scenarios = uml.getScenarios();
		final List<Component> components = uml.getComponents();
		final List<Link> links = uml.getLinks();
		
		final Reliability reliability = new Reliability(scenarios, components, links); 
		
		System.out.println(reliability.compute());
	}
}
