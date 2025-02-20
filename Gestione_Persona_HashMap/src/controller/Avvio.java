package controller;

import model.Persona;
import model.PersonaCrud;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {

		PersonaCrud pc = new PersonaCrud();
		Vista v = new Vista();
		Persona persona = null;
		boolean exit = true;
		boolean trovato = false;

		do {
			int scelta = v.leggiIntero("1) inserisci persone \n2) modifica \n3) stampa scheda \n4) elimina \n5) stampa csv \n6) cerca per id  \n7) exit");
			switch (scelta) {
			case 1: 
				System.out.println("Inserisci una nuova Persona");
				persona = v.inserisci();
				pc.inserisci(v.leggiIntero("Inserisci l'id: "), persona);
				break;
			case 2:
				int modificaId = v.leggiIntero("Inserisci il codice fiscale della persona da modificare");
				if(!pc.leggi().isEmpty()) {
					if(pc.leggi().containsKey(modificaId)) {
						trovato = true;
						Persona persona2 = pc.duplica(persona);
						v.modifica(persona2);
						if(v.leggiStringa("Confermi la modifica?").equalsIgnoreCase("si")) {
							pc.modifica(modificaId, persona2);
						}
					}
				}
				if(!trovato) {
					System.out.println("Nessun codice fiscale corrispondente");
				}
				break;
			case 3:
				v.stampaCsv(pc.leggi());
				break;
			case 4:
				int cancella = v.leggiIntero("Inserisci il codice fiscale persona da cancellare");
				if (!pc.leggi().isEmpty()) {
					if(pc.leggi().containsKey(cancella)) {

					}
					if(!trovato) {
						System.out.println("Nessun codice fiscale corrispondente");
					}
				}
				break;
			case 5:
				v.stampaScheda(pc.leggi());
				break;
			case 6:
				if (!pc.leggi().isEmpty()) {
					String ricerca = v.leggiStringa("Inserisci l'id della persona da cercare");
					for (int i = 0; i < pc.leggi().size(); i++) {
						if(ricerca.equalsIgnoreCase(pc.leggi(i).getCodiceFiscale())) {
							trovato = true;
							System.out.println(pc.leggi().toString());
							break;
						}
					}
					if(!trovato) {
						System.out.println("Nessun id corrispondente");
					}
				}
				break;
			case 7:
				exit = false;
				break;

			default:
				System.out.println("Valore inaspettato, inserisci un numero compreso nel menu...");
				break;
			}
		} while (exit);
	}
}
