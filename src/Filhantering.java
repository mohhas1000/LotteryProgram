//Namn: Mohamed Hasan

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Filhantering {
	// Filhantering-klassens attributer.
	private static Filhantering f = null;
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;
	private BufferedReader br;
	
	private Filhantering() {  //En funktion som endast printar ut texten "Ny instans skapad" vid första skapande instansen av klassen filhantering
		System.out.println("Ny instans skapad");    
		}

	public static Filhantering getInstance() {//Skapar en instans av klassen filhantering om inte det har skapats än, annars skicka ett meddelande till användare om att det har redan skapats.
		//Därefter returnerar referensen till klassen.
		if (f == null) {
			f = new Filhantering();
		} else {
			JOptionPane.showMessageDialog(null, "instansen av klassen har redan skapats!");
		}
		return f;
	}

	public void SavetoFile(JTextArea t) {//Funktionen tar emot referensen till JTextarea som parameter för att kunna spara innehållet till en fil.

		try {
			
			file = new File("Lottorader.txt");  //Försker skapa en fil "laboration5.txt" 
			fw = new FileWriter(file, true); //Denna metoden skapar ett fileWrite objekt ges ett file-objekt med en boolean som innebär att det ska skrivas in. Används för att skriva till teckenfiler
			bw = new BufferedWriter(fw); //Bufferwriter skriver text till teckenutmatningsström. Det ger en effektiv skrivning (bättre prestanda). för enstaka tecken och matriser 
			bw.write(t.getText());
			bw.close();
		

		} catch (IOException e1) { //Om ett fel uppstår printa ut texten "Går inte att skriva till filen".
			System.out.println("Går inte att skriva till filen");
		}
	}

	public void OpenFile(JTextArea t) { //Funktionen tar emot referensen till JTextarea som parameter för att kunna sedan visa det som finns i filen.
		String Text;
		try {
			br = new BufferedReader(new FileReader("Lottorader.txt")); //Läser text från en teckeninmatningsström (bättre prestanda).
			t.append("\nFilens innehåll;" + "\n");
			while ((Text = br.readLine()) != null) {
				t.append(Text + "\n");
			}
			t.append("\n");
		} catch (IOException e2) {
			System.out.println("Går inte att läsa filen");
		}

	}

	public void DeleteFile() { //Funktionen har som uppgift att radera allt som finns i filen. 
		PrintWriter pw;
		try {
			pw = new PrintWriter("Lottorader.txt"); //Skapar en ny PrintWriter med den angivna filen.
			pw.close();//stänger av strömmen
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
