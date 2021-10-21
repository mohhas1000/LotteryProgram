//Namn: Mohamed Hasan

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//implementerar actionlistener f�r att definiera vad som ska g�ras n�r en anv�ndare utf�r en viss operation.
//WindowsAdapter �r en abstrakt klass f�r ta emot f�nsterh�ndelse som till exempel n�r ett f�nster har st�ngts ner.
public class ControllerLyssnare extends WindowAdapter implements ActionListener { 
	
	//Control-klassens attributer. 
	private View view;   
	private Model m;
	private Filhantering f;
	
	public ControllerLyssnare(View v) {//Konstruktor tar emot en parameter av typen View fr�n View klassen, f�r att kunna anropa p� funktioner n�r n�got h�nder p� skr�men (lyssnare).
		view = v;
		m=new Model(); //Skapar en instans av klassen model f�r att kunna komma �t dess funktioner. 
		f=Filhantering.getInstance(); // En instans av singleton klassen.
	}
	@Override
	public void actionPerformed(ActionEvent e) { //Metoden actionperformed hanterar alla �tg�rder (actions) som till exempel n�r anv�ndare klickar p� en knapp
		JMenuItem item = (JMenuItem)e.getSource(); //Skapar en variabel av typen JMenuItem och tilldelar den med det som metoden actioneperformed tar emot. Dvs hitta vilken ->
		//->komponent som en anv�ndare har klickat p�, med metoden getSource. Metoden getSource ger dig en referens till objektet som h�ndelsen kom fr�n.
		
		if(item.getText().equals("Clear")) { //Anropa p� funktionen Clearscreen n�r clear-menuitem har klickats.
			view.Clearscreen();
		}
		
		if(item.getText().equals("Slumparad")) { //N�r slumprad-menuitem har klickat d� ska funktionen Appendonscreen anropas och skicka det v�rdet (array med 7 unika tal)->
			//->som returneras fr�n funktionen Slumptal, som parameter.
			view.Appendonscreen(m.Slumpatal());
		}
		if(item.getText().equals("�ppna")) { //Anropa p� funktionen Openfile n�r �ppna-menuitem har klickats.
			f.OpenFile(view.getTextarea());
			}
		if(item.getText().equals("Spara")) {//Anropa p� funktionen savetoFile n�r spara-menuitem har klickat och visa meddelandet "Inneh�llet har sparat" f�r anv�ndaren.
			f.SavetoFile(view.getTextarea());
			JOptionPane.showMessageDialog(null,"Inneh�llet har sparat!");
			}
		if(item.getText().equals("Delete")) {//Anropa p� funktionen deletefile n�r delete-menuitem har klickat och visa meddelandet "Filens inneh�ll har raderats" f�r anv�ndaren.
			f.DeleteFile();
			JOptionPane.showMessageDialog(null,"Filens inneh�ll har raderats!");
			}
		if(item.getText().equals("Avsluta")) {
			System.exit(0);
		}
	}
	
	public void windowClosing (WindowEvent e){//St�ng av programmet n�r f�nstret har st�ngts ner. 
		System.exit(0);
	}

}
