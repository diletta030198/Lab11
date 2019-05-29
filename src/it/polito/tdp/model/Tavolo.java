package it.polito.tdp.model;

public class Tavolo {
	private int id; 
	private int numeroPosti;
	private boolean libero;
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public boolean isLibero() {
		return libero;
	}
	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	public Tavolo(int id, int numeroPosti, boolean libero) {
		super();
		this.id = id;
		this.numeroPosti = numeroPosti;
		this.libero = libero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
