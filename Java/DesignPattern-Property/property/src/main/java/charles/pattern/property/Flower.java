package charles.pattern.property;

public class Flower implements Cloneable{
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Object clone() throws CloneNotSupportedException{
		Flower f = (Flower)super.clone();
		return f;
	}
	
}
