package tp4actions;

@SuppressWarnings("serial")
public class ExceptionActionComposee extends Exception{

	public ExceptionActionComposee(int codeErr){
		switch (codeErr){
		case 1: System.err.println("Erreur : Vous d�passez la capacit� de l'action compos�e");; break;
		case 2:  System.err.println("Erreur : le pourcentage doit �tre compris entre 0 et 1 (exclus)"); break;
		case 3: System.err.println("Erreur : l'action n'est pas enti�rement compos�e"); break;
		}
	}
}
