package it.polito.tdp.model;

import java.time.LocalTime;

public class Evento implements Comparable<Evento>{
	
	public enum TipoEvento {
		
		ARRIVO_GRUPPO,
		
		OUT
	}
	
	private int minutoArrivo;
	private TipoEvento tipo;
	private int numPersone;
	private int durata;
	private float tolleranza;
	
	private Tavolo tavolo; 
	public int getMinutoArrivo() {
		return minutoArrivo;
	}
	public void setMinutoArrivo(int minutoArrivo) {
		this.minutoArrivo = minutoArrivo;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public int getNumPersone() {
		return numPersone;
	}
	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	
	public Evento(int minutoArrivo, TipoEvento tipo, int numPersone, int durata, float tolleranza, Tavolo tavolo) {
		super();
		this.minutoArrivo = minutoArrivo;
		this.tipo = tipo;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tavolo = tavolo;
	}
	@Override
	public int compareTo(Evento altro) {
		
		return this.minutoArrivo-altro.getMinutoArrivo();
	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	@Override
	public String toString() {
		return "Evento [minutoArrivo=" + minutoArrivo + ", tipo=" + tipo + ", numPersone=" + numPersone + ", durata="
				+ durata + ", tolleranza=" + tolleranza + ", tavolo=" + tavolo + "]";
	}
	
	
	
	

}
