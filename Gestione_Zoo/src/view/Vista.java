package view;

import java.util.Scanner;

import model.Animale;
import model.Cane;
import model.DelfinoCurioso;
import model.Uccello;

public class Vista implements IVista{
	Scanner input = new Scanner(System.in);

	@Override
	public String leggiStringa(String stringa) {
		System.out.println(stringa);
		return input.nextLine();
	}

	public char leggiChar(String stringa) {
		System.out.println(stringa);
		return input.nextLine().charAt(0);
	}

	@Override
	public int leggiIntero(String stringa) {
		boolean flagi;
		int intero = 0;
		do {
			try {
				System.out.println(stringa);
				intero = Integer.parseInt(input.nextLine());
				flagi = false;
			} catch (NumberFormatException e) {
				System.out.println("Inserire un valore numerico intero");
				flagi = true;
			}
		}while (flagi);
		return intero;
	} 

	@Override
	public double leggiDouble(String stringa) {
		boolean flagd;
		double doubl = 0;
		do {
			flagd = false;
			try {
				System.out.println(stringa);
				doubl = Double.parseDouble(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Inserire un valore numerico");
				flagd = true;
			}
		}while (flagd);
		return doubl;
	}

	@Override
	public boolean leggiBoolean(String stringa) {
		String s = leggiStringa(stringa);
		boolean flag = false;
		if(s.equalsIgnoreCase("si"))
			flag = true;
		else if (s.equalsIgnoreCase("no")){
			flag = false;
		}
		return flag;
	}

	public void inserimento(Animale a) {
		if (a instanceof Cane) {
			((Cane) a).setColore(leggiStringa("Inserisci il colore: "));
			((Cane) a).setRazza(leggiStringa("Inserisci razza: "));
			((Cane) a).setSesso(leggiChar("Maschio o Femmina?"));
			((Cane) a).setVaccinato(leggiBoolean("Vaccinato?"));
		}
		else if (a instanceof Uccello) {
			((Uccello) a).setAperturaAlare(leggiIntero("Inserisci apertura alare"));
			((Uccello) a).setRazza(leggiStringa("Inserisci razza: "));
			((Uccello) a).setVelocita(leggiIntero("Inserisci velocita: "));
		}
		else if (a instanceof DelfinoCurioso) {
			((DelfinoCurioso) a).setLunghezza(leggiDouble("Inserisci lunghezza"));
			((DelfinoCurioso) a).setMoltoCurioso(leggiBoolean("Curioso?"));
			((DelfinoCurioso) a).setNome(leggiStringa("Inserisci nome: "));
		}
	}

	public void modificaBase(Animale a) {
		System.out.println("Peso Animale: " + a.getPesoAnimale());
		a.setPesoAnimale(leggiDouble("Inserisci nuovo peso: "));

		System.out.println("Habitat: " + a.getHabitat());
		a.setHabitat(leggiStringa("Inserisci nuovo habitat: "));

		System.out.println("Dieta: " + a.getDieta());
		a.setHabitat(leggiStringa("Inserisci nuova dieta: "));
	}

	public void modificaAnimale(Animale a) {
		if (a instanceof Cane) {
			modificaBase(a);
			System.out.println("Colore: " + ((Cane) a).getColore());
			((Cane) a).setColore(leggiStringa("Inserisci nuovo colore: "));

			System.out.println("Razza: " + ((Cane) a).getRazza());
			((Cane) a).setRazza(leggiStringa("Inserisci nuova razza: "));

			System.out.println("Sesso: " + ((Cane) a).getSesso());
			((Cane) a).setSesso(leggiChar("Inserisci nuovo sesso: "));
		}
		else if (a instanceof Uccello) {
			modificaBase(a);
			System.out.println("Apertura alare: " + ((Uccello) a).getAperturaAlare());
			((Uccello) a).setAperturaAlare(leggiIntero("Inserisci nuova apertura alare: "));

			System.out.println("Razza: " + ((Uccello) a).getRazza());
			((Uccello) a).setRazza(leggiStringa("Inserisci nuova razza: "));

			System.out.println("Velocit�: "	+ ((Uccello) a).getVelocita());
			((Uccello) a).setVelocita(leggiIntero("Inserisci nuova velocit�: "));
		}
		else if (a instanceof DelfinoCurioso) {
			modificaBase(a);
			System.out.println("Lunghezza: " + ((DelfinoCurioso) a).getLunghezza());
			((DelfinoCurioso) a).setLunghezza(leggiIntero("Inserisci nuova lunghezza: "));

			System.out.println("Nome: " + ((DelfinoCurioso) a).getNome());
			((DelfinoCurioso) a).setNome(leggiStringa("Inserisci nuovo nome: "));

			System.out.println("Curioso!? " + ((DelfinoCurioso) a).isMoltoCurioso());
			((DelfinoCurioso) a).setMoltoCurioso(leggiBoolean("E' curioso? "));
		}
	}

	public Animale duplica(Animale a) {
		Animale a1=null;
		if (a instanceof Cane) {
			a1=new Cane(a.getPesoAnimale(),a.getHabitat(),a.getDieta(),((Cane) a).getRazza(), ((Cane) a).getColore(), ((Cane) a).isVaccinato(), ((Cane) a).getSesso());
		}else if(a instanceof Uccello) {
			a1=new Uccello(a.getPesoAnimale(),a.getHabitat(),a.getDieta(),((Uccello) a).getVelocita(), ((Uccello) a).getAperturaAlare(), ((Uccello) a).getRazza());
		}else if(a instanceof DelfinoCurioso) {
			a1=new DelfinoCurioso(a.getPesoAnimale(), a.getHabitat(), a.getDieta(), ((DelfinoCurioso) a).isMoltoCurioso(), ((DelfinoCurioso) a).getNome(), ((DelfinoCurioso) a).getLunghezza());
		}
		return a1;
	}

	public void stampaScheda(Animale[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] instanceof Cane) {
				System.out.println("Tipo: " + a[i].getTipoAnimale());
				System.out.println("Habitat: " + a[i].getHabitat());
				System.out.println("Peso Animale: " + a[i].getPesoAnimale());
				System.out.println("Colore Animale: " + ((Cane)a[i]).getColore());
				System.out.println("Razza Animale: " + ((Cane)a[i]).getRazza());
				System.out.println("Sesso Animale: " + ((Cane)a[i]).getSesso());
				System.out.println("E' Vaccinato?: " + ((Cane)a[i]).isVaccinato());
			}
			else if (a[i] instanceof Uccello) {
				System.out.println("Tipo: " + a[i].getTipoAnimale());
				System.out.println("Habitat: " + a[i].getHabitat());
				System.out.println("Peso Animale: " + a[i].getPesoAnimale());
				System.out.println("Apertura Alare" + ((Uccello)a[i]).getAperturaAlare());
				System.out.println("Razza: " + ((Uccello)a[i]).getRazza());
				System.out.println("Velocit�: " + ((Uccello)a[i]).getVelocita());
			}
			else if (a[i] instanceof DelfinoCurioso) {
				System.out.println("Tipo: " + a[i].getTipoAnimale());
				System.out.println("Habitat: " + a[i].getHabitat());
				System.out.println("Peso Animale: " + a[i].getPesoAnimale());
				System.out.println("Lunghezza: " + ((DelfinoCurioso)a[i]).getLunghezza());
				System.out.println("Nome: " + ((DelfinoCurioso)a[i]).getNome());
			}
		}
	}
}
