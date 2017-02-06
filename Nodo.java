package Polinomios;


public class Nodo {
	
	private Monomio dato;
	private Nodo siguiente;
	
	
	public Nodo(Monomio d){
		dato=d;
		siguiente = null;
	}
	
	public Monomio getDato() {
		return dato;
	}
	
	public void setDato(Monomio dato) {
		this.dato = dato;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
	public String toString(){
		
		String a=this.dato.getCoeficiente()+"x^"+this.dato.getExponente();
		return a;
		
	}

}
