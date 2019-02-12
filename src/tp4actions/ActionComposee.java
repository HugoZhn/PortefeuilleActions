package tp4actions;

import java.util.HashMap;

public class ActionComposee extends Action {

	private HashMap<ActionSimple, Double> actions;

	// Constructeurs
	public ActionComposee(String lib) {
		this.libelle = lib;
		this.actions = new HashMap<ActionSimple, Double>();
	}

	public ActionComposee(String lib, HashMap<ActionSimple, Double> actions) {
		this.libelle = lib;
		this.actions = actions;
	}

	// Getters
	public String getLibelle(){
		return this.libelle;
	}

	public HashMap<ActionSimple, Double> getActions() {
		return this.actions;
	}
	
	
	// Permet de supprimer une action de l'action composée
	public void remove(ActionSimple a){
		if(this.actions.containsKey(a)){
			this.actions.remove(a);
		}
	}
	
	// Indique si l'action est composée à moins de 100%
	private boolean inf100(){
		double sum = 0;
		for(Double perc : this.actions.values()){
			sum += perc;
		}
		return sum<1;
	}

	// Indique si l'action composée + le pourcentage d'ajout dépasse 100%
	private boolean sup100(double addedPerc){
		double sum = 0;
		for(Double perc : this.actions.values()){
			sum += perc;
		}
		sum += addedPerc;
		return sum>1;
	}

	// Permet d'ajouter/modifier le pourcentage d'une action dans la composition
	public void add(ActionSimple a, double pourc) throws ExceptionActionComposee{
		// Le pourcentage doit être entre 0 et 1 sinon on lève une erreur
		if(pourc >0 && pourc<1){
			
			// Si l'action composée ne contient pas déjà l'action 
			// et l'ajout du pourcentage de la nouvelle action ne dépasse pas 100% on l'ajoute sinon on lève une erreur
			if(!this.actions.containsKey(a)){
				if(!this.sup100(pourc)){
					this.actions.put(a, pourc);
				}
				else{
					throw new ExceptionActionComposee(1);
				}
			}
			// Si l'action composée contient déjà l'action 
			// et l'ajout du pourcentage de cette action ne dépasse pas 100% on l'ajoute sinon on lève une erreur
			else{
				if(!this.sup100(this.actions.get(a) + pourc)){
					this.actions.put(a, pourc);
				}
				else{
					throw new ExceptionActionComposee(1);
				}
			}
		}
		else{
			throw new ExceptionActionComposee(2);
		}
	}

	// Renvoie la valeur de l'action un jour donnée si l'action est composée à 100%
	@Override
	public double getValeur(Date d) throws ExceptionActionComposee {
		double val=0;
		if(!this.inf100()){
			for(ActionSimple key : this.actions.keySet()){
				val += key.getValeur(d) * this.actions.get(key);
			}
		}
		else{
			throw new ExceptionActionComposee(3);
		}
		return val;
	}

	// Renvoie la valeur de l'action du dernier jour si l'action est composée à 100%
	public double getDerValeur() throws ExceptionActionComposee {
		double val=0;
		if(!this.inf100()){
			for(ActionSimple key : this.actions.keySet()){
				val += key.getDerValeur() * this.actions.get(key);
			}
		}
		else{
			throw new ExceptionActionComposee(3);
		}
		return val;
	}

	public String toString(){
		String ret = "Action composée '" + this.libelle +"' : [ ";
		for(Action key : this.actions.keySet()){
			ret += key.toString() + " (" + this.actions.get(key)*100 + "%), ";
		}
		ret = ret.substring(0, ret.length()-2);
		ret += "]";
		return ret;
	}

}
