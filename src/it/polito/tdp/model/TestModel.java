package it.polito.tdp.model;

public class TestModel {
	public static void main (String[] args) {
		
		Model model = new Model(); 
		model.simula();
		
		System.out.println(model.numeroTotale());
		System.out.println(model.numeroSoddisfatti());
		System.out.println(model.numeroInsoddisfatti());
		 System.out.println(model.numeroOUT());
		
		
	}
	
	
	
	
	
	


}
