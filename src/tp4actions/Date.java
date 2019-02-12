package tp4actions;

import java.util.Calendar;

public class Date {
	
	private int jour;
	private int mois;
	private int annee;
	private int toInt;
	
	public Date(){
		Calendar today = Calendar.getInstance();
		this.jour  = today.get(Calendar.DATE);
		this.mois = today.get(Calendar.MONTH)+1;
		this.annee = today.get(Calendar.YEAR);
		this.toInt = this.annee*10000 + this.mois*100 + jour;
	}
	
	public Date(int jour, int mois, int annee){
		this.jour  = jour;
		this.mois = mois;
		this.annee = annee;
		this.toInt = annee*10000 + mois*100 + jour;
	}
	
	public int getToInt(){
		return this.toInt;
	}
	
	public static Date fromInt(int i){
		int year = i/10000;
		i -= year;
		int month = i/100;
		i -= month;
		Date retour = new Date(i, month, year);
		return retour;
	}
	
	@Override
	public int hashCode() {
		return this.toInt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (toInt != other.toInt)
			return false;
		return true;
	}

	public String toString(){
		
		String jourStr = Integer.toString(this.jour);
		if(jourStr.length()==1){
			jourStr = "0" + jourStr;
		}
		
		String moisStr = Integer.toString(this.mois);
		if(moisStr.length()==1){
			moisStr = "0" + moisStr;
		}
		
		return jourStr + "/" + moisStr + "/" + annee;
	}
}
