package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simulatore {
	
	private PriorityQueue <Evento> queue= new PriorityQueue<>();
	
	

	//stato del mondo
	private List<Tavolo> tavoli = new LinkedList<Tavolo>();
	
	
	//parametri della simulazione 
	private final int num_eventi= 2000; 
	
	//statistiche raccolte
	private int numSoddisfatti;
	private int numInsoddisfatti; 
	private int numTotale; 
	
	
	//variabili interne
	private Random rand= new Random();
	
	
	
	public void init() {
		for(int i=1; i<3;i++) {
			Tavolo t= new Tavolo(i,10,true);
			tavoli.add(t);
		}
		for(int i=1; i<5;i++) {
			Tavolo t= new Tavolo(i,8,true);
			tavoli.add(t);
		}
		for(int i=1; i<5;i++) {
			Tavolo t= new Tavolo(i,6,true);
			tavoli.add(t);
		}
		for(int i=1; i<6;i++) {
			Tavolo t= new Tavolo(i,4,true);
			tavoli.add(t);
		}
		
		
		this.numInsoddisfatti=0;
		this.numSoddisfatti=0;
		this.numTotale=0;
		
		this.queue.clear();
		
		//carico gli eventi iniziali
		int tempo =0; 
		 for(int i = 0; i<this.num_eventi; i++) {
			 Evento e = new Evento (tempo, TipoEvento.ARRIVO_GRUPPO,rand.nextInt(10)+1,rand.nextInt(61)+60,rand.nextFloat(),null);
		    queue.add(e);
		    tempo=tempo+rand.nextInt(10)+1;
		 
		 }
		
	}
	int conta=0; 
	
	public void run() {
		
		
		
		while(!queue.isEmpty()) {
		
			Evento ev= queue.poll();
			System.out.println(ev.toString());
			
			
			switch (ev.getTipo()) {
			case ARRIVO_GRUPPO:
				this.numTotale+= ev.getNumPersone();
				
				
				Tavolo ottimo= new Tavolo(0,Integer.MAX_VALUE,false); 
			    
				for (Tavolo t: tavoli) {
					if(t.getNumeroPosti()>=ev.getNumPersone() && t.isLibero()==true && t.getNumeroPosti()/2<=ev.getNumPersone()) {
						if(t.getNumeroPosti()<ottimo.getNumeroPosti()) {
							
							ottimo= t; 
						
						}
						
					}
					
				}
				if(ottimo.getId()==0) {
					//non ho trovato un tavolo
					float probabilita= rand.nextFloat();
					if(ev.getTolleranza()>=probabilita) {
						//i clienti si siedono
						this.numSoddisfatti+=ev.getNumPersone();
						//Evento out= new Evento(ev.getMinutoArrivo()+ev.getDurata(),TipoEvento.OUT,ev.getNumPersone(),0,0,null);
						//queue.add(out);
						
					}
					else {
						//i clienti non si siedono
						this.numInsoddisfatti+=ev.getNumPersone();
					}
					
					
				}
				else {
					//ho trovato un tavolo
				System.out.println("Hai trovato un tavolo");
					ottimo.setLibero(false);
					this.numSoddisfatti+=ev.getNumPersone();
					Evento out= new Evento(ev.getMinutoArrivo()+ev.getDurata(),TipoEvento.OUT,ev.getNumPersone(),0,0,ottimo);
					queue.add(out);
					System.out.println(out.toString());
					
				}
				break; 
			case OUT:
				ev.getTavolo().setLibero(true);
				conta++; 
			}
			
		}
	}

	public PriorityQueue<Evento> getQueue() {
		return queue;
	}

	public void setQueue(PriorityQueue<Evento> queue) {
		this.queue = queue;
	}

	public int getNumSoddisfatti() {
		return numSoddisfatti;
	}

	public void setNumSoddisfatti(int numSoddisfatti) {
		this.numSoddisfatti = numSoddisfatti;
	}

	public int getNumInsoddisfatti() {
		return numInsoddisfatti;
	}

	public void setNumInsoddisfatti(int numInsoddisfatti) {
		this.numInsoddisfatti = numInsoddisfatti;
	}

	public int getNumTotale() {
		return numTotale;
	}

	public void setNumTotale(int numTotale) {
		this.numTotale = numTotale;
	}
	
	public int getConta() {
		return this.conta;
	}
	
	
}
