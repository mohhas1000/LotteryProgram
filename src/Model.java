//Namn: Mohamed Hasan

import java.util.Arrays;
import java.util.Random;

public class Model {   //En klass som har som uppgift att returnera en array med 7 unika heltal.
	private final int MAX_ANTAL =35; // konstant variabel med v�rdet 35
	
	public String Slumpatal() { //Funktionen slumptal
		int [] box=new int[MAX_ANTAL]; //En array med 35 platser
		int [] jetski=new int[7];
		Random r = new Random(); //Skapar en instans av klassen Random f�r att senare komma �t funktionen nextInt.
		
		for(int j=0; j<MAX_ANTAL; j++) { //For-loopen g�r 35 varv, d�r varje loop ger ett v�rde till arrayen. Det g�r fr�n 1 till 35.
			box[j]=j+1;
		}
		for(int i=0; i<MAX_ANTAL; i++) { //En For-loop som byter plats p� tv� tal f�r att g�ra det osorterad. 35 varv. 
			int swap = r.nextInt(box.length); //Slumpar ett tal fr�n 0 till 35 och tilldelar den till variabeln swap
			int temp = box[swap]; 
			box[swap]= box[i]; 
			box[i]=temp;
		}
		for(int x=0; x<7;x++) {//En For-loop som utf�r 7 varv och f�r varje varv tilldelar ett v�rde till den nya arrayen. Den nya arrayen f�r 7 unika tal. 
			jetski[x]=box[x];
		}
		Arrays.sort(jetski); //Sorterar den nya arrayen. minsta talet till v�nster och st�rsta till h�ger.
		return Arrays.toString(jetski); //Returnerar den nya arreyen.
		
	}

}
