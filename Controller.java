package Polinomios;


public class Controller {
	private Nodo inicio;

	public Controller() {
		inicio = null;

	}

	public void insertar(int coeficiente, int exponente) {
		Monomio datos = new Monomio();
		datos.setCoeficiente(coeficiente);
		datos.setExponente(exponente);
		Nodo nuevo = new Nodo(datos);
		Nodo aux = inicio;

		if (inicio == null) {
			inicio = nuevo;
		} else {
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
	}


	public void imprimirPolinomio() {
		Nodo aux = inicio;
		System.out.printf("\n");
		while (aux != null) {
			System.out.printf("%s ", aux.toString());
			aux = aux.getSiguiente();
		}

	}


	public void ordenarPolinomio() throws ListaVaciaException {
		if (inicio == null) {
			throw new ListaVaciaException();
		}
		Nodo aux = inicio;
		Nodo aux2 = null;
		Integer auxCoeficiente = 0;
		Integer auxExponente = 0;

		while (aux != null) {
			aux2 = aux.getSiguiente();
			while (aux2 != null) {
				if (aux.getDato().getExponente() < aux2.getDato().getExponente()) {
					auxCoeficiente = aux.getDato().getCoeficiente();
					auxExponente = aux.getDato().getExponente();
					aux.getDato().setCoeficiente(aux2.getDato().getCoeficiente());
					aux.getDato().setExponente(aux2.getDato().getExponente());
					aux2.getDato().setCoeficiente(auxCoeficiente);
					aux2.getDato().setExponente(auxExponente);

				}
				aux2 = aux2.getSiguiente();
			}
			aux = aux.getSiguiente();
		}

	}

	public void simplificar() throws ListaVaciaException {
		if (inicio == null) {
			throw new ListaVaciaException();
		} else {
			Integer auxCoeficiente = 0;
			Integer auxExponente = 0;
			Integer auxDatos;
			ordenarPolinomio();
			int contador = 0;
			Nodo aux = inicio;
			//conteo de datos en el polinomio
			while (aux.getSiguiente() != null) {
				contador = contador + 1;
				aux = aux.getSiguiente();
			}
			Nodo ListaSiguiente = aux;
			aux = inicio;
			for (int i = 0; i <= contador;) {
				auxDatos = aux.getDato().getExponente();
				auxCoeficiente = 0;
				while (auxDatos == aux.getDato().getExponente() && aux != null) {
					i = i + 1;
					auxCoeficiente = auxCoeficiente + aux.getDato().getCoeficiente();
					auxExponente = aux.getDato().getExponente();
					aux = aux.getSiguiente();
				}
				insertar(auxCoeficiente, auxExponente);
			}
			inicio = ListaSiguiente.getSiguiente();
		}
	}

	public void suma(Controller polinomio) throws ListaVaciaException {

		Controller poliSuma = new Controller();

		Nodo aux1 = polinomio.inicio;
		Nodo aux = inicio;
		while (aux1 != null) {
			poliSuma.insertar(aux1.getDato().getCoeficiente(), aux1.getDato().getExponente());
			aux1 = aux1.getSiguiente();
		}

		while (aux.getSiguiente() != null) {
			aux = aux.getSiguiente();
		}
		aux.setSiguiente(poliSuma.inicio);
		simplificar();

	}

	public void restarPolinomio(Controller polinomioResta) throws ListaVaciaException {

		Controller poliResta = new Controller();
		Nodo aux1 = polinomioResta.inicio;
		while (aux1 != null) {
			poliResta.insertar(aux1.getDato().getCoeficiente(), aux1.getDato().getExponente());
			aux1 = aux1.getSiguiente();
		}
		Nodo aux = inicio;
		Nodo auxPolinomioResta = poliResta.inicio;
		Integer auxCoeficiente = 0;
		while (aux.getSiguiente() != null) {
			aux = aux.getSiguiente();
		}
		while (auxPolinomioResta != null) {
			auxCoeficiente = -1 * auxPolinomioResta.getDato().getCoeficiente();
			auxPolinomioResta.getDato().setCoeficiente(auxCoeficiente);
			auxPolinomioResta = auxPolinomioResta.getSiguiente();
		}
		aux.setSiguiente(poliResta.inicio);
		simplificar();
	}


	public void multiplicarPolinomio(Controller polinomioMultiplicado) throws ListaVaciaException {

		Nodo aux;
		Controller listaAuxiliar = new Controller();
		Nodo auxPolinomioMultiplicar = polinomioMultiplicado.inicio;
		Integer auxCoeficiente = 0;
		Integer auxExponente = 0;

		while (auxPolinomioMultiplicar != null) {
			aux = inicio;
			while (aux != null) {
				auxCoeficiente = aux.getDato().getCoeficiente() * auxPolinomioMultiplicar.getDato().getCoeficiente();
				auxExponente = aux.getDato().getExponente() + auxPolinomioMultiplicar.getDato().getExponente();

				aux = aux.getSiguiente();
				listaAuxiliar.insertar(auxCoeficiente, auxExponente);
			}
			auxPolinomioMultiplicar = auxPolinomioMultiplicar.getSiguiente();
		}
		inicio = listaAuxiliar.inicio;
		simplificar();

	}


	
}




