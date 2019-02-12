package tp4actions;

@SuppressWarnings("serial")
public class ExceptionPortefeuille extends Exception{

	public ExceptionPortefeuille(int codeErr){
		switch (codeErr){
		case 1: System.err.println("Erreur : Vous ne pouvez pas acheter un nombre n�gatif d'actions"); break;
		case 2:  System.err.println("Erreur : Vous ne pouvez pas vendre un nombre n�gatif d'actions"); break;
		case 3: System.err.println("Erreur : Vous ne pouvez pas vendre plus d'actions que vous en avez"); break;
		case 4: System.err.println("Erreur : Vous ne pouvez pas vendre une action que vous ne possedez pas"); break;
		}
	}
        
        // Test Sonia
	
}
