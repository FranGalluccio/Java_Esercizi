package model;

public class Cerchio extends FiguraGeometrica{
	
	private double raggio;
	
	@Override
	public String[] getInfoFiguraGeometrica() {
		String[] informazioni = new String[4];
		for (int i = 0; i < super.getInfoFiguraGeometrica().length; i++) {
			informazioni[i] = super.getInfoFiguraGeometrica()[i];
		}
		informazioni[3] = "Raggio: " + raggio;
		return informazioni;
	}
	
	public Cerchio() {
		super("Cerchio");
	}
	public Cerchio(double raggio) {
		super("Cerchio");
		this.raggio = raggio;
	}

	@Override
	public double getPerimetro() {
		return raggio * (3.14 * 2);
	}
	@Override
	public double getArea() {
		return raggio * raggio * 3.14;
	}

	public double getRaggio() {
		return raggio;
	}
	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}
	@Override
	public String toString() {
		return super.toString() + "," + raggio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(raggio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Cerchio other = (Cerchio) obj;
		if (Double.doubleToLongBits(raggio) != Double.doubleToLongBits(other.raggio))
			return false;
		return true;
	}
}
