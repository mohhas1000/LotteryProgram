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
	
	private Filhantering() {  //En funktion som endast printar ut texten "Ny instans skapad" vid f�rsta skapande instansen av klassen filhantering
		System.out.println("Ny instans skapad");    
		}

	public static Filhantering getInstance() {//Skapar en instans av klassen filhantering om inte det har skapats �n, annars skicka ett meddelande till anv�ndare om att det har redan skapats.
		//D�refter returnerar referensen till klassen.
		if (f == null) {
			f = new Filhantering();
		} else {
			JOptionPane.showMessageDialog(null, "instansen av klassen har redan skapats!");
		}
		return f;
	}

	public void SavetoFile(JTextArea t) {//Funktionen tar emot referensen till JTextarea som parameter f�r att kunna spara inneh�llet till en fil.

		try {
			
			file = new File("Lottorader.txt");  //F�rsker skapa en fil "laboration5.txt" 
			fw = new FileWriter(file, true); //Denna metoden skapar ett fileWrite objekt ges ett file-objekt med en boolean som inneb�r att det ska skrivas in. Anv�nds f�r att skriva till teckenfiler
			bw = new BufferedWriter(fw); //Bufferwriter skriver text till teckenutmatningsstr�m. Det ger en effektiv skrivning (b�ttre prestanda). f�r enstaka tecken och matriser 
			bw.write(t.getText());
			bw.close();
		

		} catch (IOException e1) { //Om ett fel uppst�r printa ut texten "G�r inte att skriva till filen".
			System.out.println("G�r inte att skriva till filen");
		}
	}

	public void OpenFile(JTextArea t) { //Funktionen tar emot referensen till JTextarea som parameter f�r att kunna sedan visa det som finns i filen.
		String Text;
		try {
			br = new BufferedReader(new FileReader("Lottorader.txt")); //L�ser text fr�n en teckeninmatningsstr�m (b�ttre prestanda).
			t.append("\nFilens inneh�ll;" + "\n");
			while ((Text = br.readLine()) != null) {
				t.append(Text + "\n");
			}
			t.append("\n");
		} catch (IOException e2) {
			System.out.println("G�r inte att l�sa filen");
		}

	}

	public void DeleteFile() { //Funktionen har som uppgift att radera allt som finns i filen. 
		PrintWriter pw;
		try {
			pw = new PrintWriter("Lottorader.txt"); //Skapar en ny PrintWriter med den angivna filen.
			pw.close();//st�nger av str�mmen
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
