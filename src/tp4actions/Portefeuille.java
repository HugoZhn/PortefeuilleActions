package tp4actions;

import java.util.HashMap;

public class Portefeuille {
	private String nom;
	private HashMap<Action, Integer> contenu;

	public Portefeuille(String n) {
		this.nom = n;
		this.contenu = new HashMap<Action, Integer>();
	}

	public Portefeuille(String n, HashMap<Action, Integer> actions) {
		this.nom = n;
		this.contenu = actions;
	}

	public String getNom(){
		return this.nom;
	}

	public HashMap<Action, Integer> getContenu() {
		return this.contenu;
	}

	public void acheter(Action a, int nbAct) throws ExceptionPortefeuille{
		if(!this.contenu.containsKey(a) && nbAct > 0){
			this.contenu.put(a, nbAct);
		}
		else if(this.contenu.containsKey(a) && nbAct > 0){
			this.contenu.put(a, this.contenu.get(a)+nbAct);
		}
		else{
			throw new ExceptionPortefeuille(1);
		}
	}
	
	public void vendre(Action a, int nbAct) throws ExceptionPortefeuille{
		 if(this.contenu.containsKey(a) && nbAct > 0 && this.contenu.get(a)-nbAct>=0){
			 this.contenu.put(a, this.contenu.get(a)-nbAct);
		 }
		 else if(this.contenu.containsKey(a) && nbAct < 0){
			 throw new ExceptionPortefeuille(2);
		 }
		 else if(this.contenu.containsKey(a) && this.contenu.get(a)-nbAct<0){
			 throw new ExceptionPortefeuille(3);
		 }
		 else{
			 throw new ExceptionPortefeuille(4);
		 }
	}

	public double getValeur(Date d) {
		double val=0;
		for(Action key: this.contenu.keySet()){
			
			try{
				val += key.getValeur(d) * this.contenu.get(key);
			}
			catch(ExceptionActionComposee e){
				e.printStackTrace();
			}
		}
		return val;
	}

	public double getDerValeur() {
		double val=0;
		for(Action key: this.contenu.keySet()){
			try{
				val += key.getDerValeur() * this.contenu.get(key);
			}
			catch(ExceptionActionComposee e){
				e.printStackTrace();
			}
		}
		return val;
	}

	public String toString(){
		String ret = "Portefeille : '"+ this.nom + "' \n";
		for(Action key : this.contenu.keySet()){
			ret += key.toString() + "\n";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}

}
