package model;

public class Triangolo extends FiguraGeometrica{

	private int latoA;
	private int latoB;
	private int latoC;
	
	@Override
	public String[] getInfoFiguraGeometrica() {
		String[] informazioni = new String[6];
		for (int i = 0; i < super.getInfoFiguraGeometrica().length; i++) {
			informazioni[i] = super.getInfoFiguraGeometrica()[i];
		}
		informazioni[3] = "LatoA " + latoA;
		informazioni[4] = "LatoB " + latoB;
		informazioni[5] = "LatoC " + latoC;
		return informazioni;
	}

	public Triangolo() {
		super("Triangolo");
	}
	public Triangolo(int latoA, int latoB, int latoC) {
		super("Triangolo");
		this.latoA = latoA;
		this.latoB = latoB;
		this.latoC = latoC;
	}
	public int getLatoA() {
		return latoA;
	}
	public void setLatoA(int latoA) {
		this.latoA = latoA;
	}
	public int getLatoB() {
		return latoB;
	}
	public void setLatoB(int latoB) {
		this.latoB = latoB;
	}
	public int getLatoC() {
		return latoC;
	}
	public void setLatoC(int latoC) {
		this.latoC = latoC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + latoA;
		result = prime * result + latoB;
		result = prime * result + latoC;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangolo other = (Triangolo) obj;
		if (latoA != other.latoA)
			return false;
		if (latoB != other.latoB)
			return false;
		if (latoC != other.latoC)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return super.toString() + "," + latoA + "," + latoB + ",=" + latoC;
	}

	@Override
	public double getPerimetro() {
		return latoA + latoB + latoC;
	}
	@Override
	public double getArea() {
		double p = (latoA + latoB + latoC) / 2;
		return Math.sqrt(p * Math.abs((p - latoA) * (p - latoB) * (p - latoC)));
	}
}