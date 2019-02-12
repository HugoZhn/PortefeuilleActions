package tp4actions;

public abstract class Action {
    
        // TEST MODIFICATION 3 DAVID
    
	protected String libelle;
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public abstract double getValeur(Date date) throws ExceptionActionComposee;
	
	public abstract double getDerValeur() throws ExceptionActionComposee;
	
	@Override
	public int hashCode() {
		return this.libelle.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
}
