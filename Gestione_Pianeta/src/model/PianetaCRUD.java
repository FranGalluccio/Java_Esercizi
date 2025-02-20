package model;

import java.util.ArrayList;

public class PianetaCRUD implements IPianetaCRUD{

	ArrayList<Pianeta> pianeta = new ArrayList<Pianeta>();

	@Override
	public boolean cancella(int indice) {
		pianeta.remove(indice);
		return true;
	}

	@Override
	public boolean modifica(int indice, Pianeta p) {
		pianeta.set((indice), p);
		return true;
	}

	@Override
	public Pianeta leggi(int i) {
		return pianeta.get(i);
	}

	@Override
	public ArrayList<Pianeta> leggi() {
		return pianeta;
	}

	@Override
	public boolean inserisci(Pianeta p) {
		pianeta.add(p);
		return true;
	}
	public Pianeta duplica(Pianeta p) {
		Pianeta p2 = new Pianeta(p.getId(), p.getNome(), p.getMassa(), p.isAbitato(), p.getColore(), p.getTemperatura(), p.getDataScoperta());
				return p2;
	}
}
