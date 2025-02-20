package view;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.*;

import model.Persona;

public class Vista {
	Scanner input = new Scanner(System.in);

	public String leggiStringa(String messaggio) {
		System.out.println(messaggio);
		return input.nextLine();
	}

	public int leggiIntero(String messaggio) {
		System.out.println(messaggio);
		return Integer.parseInt(input.nextLine());
	}
	
	public Date leggiData(String suggerimento){
        String sData=""; 
        Date data = null;
        boolean flag = true;
        do {
            flag = false;
            sData = leggiStringa(suggerimento +"(dd/MM/yyyy):"); 
            try {

                data = new SimpleDateFormat("dd/MM/yyyy").parse(sData);
            } catch (ParseException e) {
                System.out.println("Formato data non valido.");
                flag = true;
            }
        }while(flag);
        return data;
    }

	public Persona inserisci() {
		Persona p = new Persona(leggiIntero("Inserisci id: "), leggiStringa("Inserisci nome: "), leggiStringa("Inserisci cognome: "), leggiStringa("Inserisci luogo di nascita"),
				leggiStringa("Inserisci sesso"), leggiStringa("Inserisci codice fiscale"), leggiData("Inserisci data di nascita"));
				return p;
	}
	
	public void modifica(Persona p) {
		System.out.println("Id [" + p.getId()+ "]");
		p.setId(leggiIntero("Inserisci nuovo id"));

		System.out.println("Nome [" + p.getNome()+ "]");
		p.setNome(leggiStringa("Inserisci Nome: "));

		System.out.println("Cognome [" + p.getCognome()+ "]");
		p.setCognome(leggiStringa("Inserisci Cognome: "));

		System.out.println("Luogo di Nascita [" + p.getLuogoDiNascita()+ "]");
		p.setLuogoDiNascita(leggiStringa("Inserisci data di Nascita: "));

		System.out.println("Sesso [" + p.getSesso()+ "]");
		p.setSesso(leggiStringa("Inserisci Sesso: "));

		System.out.println("Codice Fiscale [" + p.getCodiceFiscale() + "]");
		p.setCodiceFiscale(leggiStringa("Inserisci Codice Fiscale: "));

		System.out.println("Data di Nascita [" + p.getDataDiNascita()+ "]");
		p.setDataDiNascita(leggiData("Inserisci Nome: "));
	}

	public void cancella(ArrayList<Persona> p) {
		p.remove(leggiIntero("Inserisci l'id della persona da rimuovere"));
	}
	
	public void stampaScheda(ArrayList<Persona> p) {
		for (Persona persona : p) {
			System.out.println("Id: " + persona.getId());
			System.out.println("Nome: " + persona.getNome());
			System.out.println("Cognome: " + persona.getCognome());
			System.out.println("Luogo di Nascita: " + persona.getLuogoDiNascita());
			System.out.println("Sesso: " + persona.getSesso());
			System.out.println("Codice Fiscale: " + persona.getCodiceFiscale());
			System.out.println("Data di Nascita: " + persona.getDataDiNascita());
		}
	}
}
