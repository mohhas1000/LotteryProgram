//Namn: Mohamed Hasan

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//implementerar actionlistener för att definiera vad som ska göras när en användare utför en viss operation.
//WindowsAdapter är en abstrakt klass för ta emot fönsterhändelse som till exempel när ett fönster har stängts ner.
public class ControllerLyssnare extends WindowAdapter implements ActionListener { 
	
	//Control-klassens attributer. 
	private View view;   
	private Model m;
	private Filhantering f;
	
	public ControllerLyssnare(View v) {//Konstruktor tar emot en parameter av typen View från View klassen, för att kunna anropa på funktioner när något händer på skrämen (lyssnare).
		view = v;
		m=new Model(); //Skapar en instans av klassen model för att kunna komma åt dess funktioner. 
		f=Filhantering.getInstance(); // En instans av singleton klassen.
	}
	@Override
	public void actionPerformed(ActionEvent e) { //Metoden actionperformed hanterar alla åtgärder (actions) som till exempel när användare klickar på en knapp
		JMenuItem item = (JMenuItem)e.getSource(); //Skapar en variabel av typen JMenuItem och tilldelar den med det som metoden actioneperformed tar emot. Dvs hitta vilken ->
		//->komponent som en användare har klickat på, med metoden getSource. Metoden getSource ger dig en referens till objektet som händelsen kom från.
		
		if(item.getText().equals("Clear")) { //Anropa på funktionen Clearscreen när clear-menuitem har klickats.
			view.Clearscreen();
		}
		
		if(item.getText().equals("Slumparad")) { //När slumprad-menuitem har klickat då ska funktionen Appendonscreen anropas och skicka det värdet (array med 7 unika tal)->
			//->som returneras från funktionen Slumptal, som parameter.
			view.Appendonscreen(m.Slumpatal());
		}
		if(item.getText().equals("Öppna")) { //Anropa på funktionen Openfile när öppna-menuitem har klickats.
			f.OpenFile(view.getTextarea());
			}
		if(item.getText().equals("Spara")) {//Anropa på funktionen savetoFile när spara-menuitem har klickat och visa meddelandet "Innehållet har sparat" för användaren.
			f.SavetoFile(view.getTextarea());
			JOptionPane.showMessageDialog(null,"Innehållet har sparat!");
			}
		if(item.getText().equals("Delete")) {//Anropa på funktionen deletefile när delete-menuitem har klickat och visa meddelandet "Filens innehåll har raderats" för användaren.
			f.DeleteFile();
			JOptionPane.showMessageDialog(null,"Filens innehåll har raderats!");
			}
		if(item.getText().equals("Avsluta")) {
			System.exit(0);
		}
	}
	
	public void windowClosing (WindowEvent e){//Stäng av programmet när fönstret har stängts ner. 
		System.exit(0);
	}

}
