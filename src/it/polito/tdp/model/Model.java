package it.polito.tdp.model;

public class Model {
	 Simulatore sim; 
	
	public void simula() {
	sim= new Simulatore();
		sim.init();
		sim.run();
	}
	
	public int numeroTotale() {
		return this.sim.getNumTotale();
	}
	
	public int numeroSoddisfatti() {
		return this.sim.getNumSoddisfatti();
	}
	
	public int numeroInsoddisfatti() {
		return this.sim.getNumInsoddisfatti();
	}
	
	public int numeroOUT() {
		return this.sim.getConta();
	}
	
	
	

}
