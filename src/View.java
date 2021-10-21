//Namn: Mohamed Hasan
  

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class View {
	//View-klassens attributer
	private JFrame f;
	private JMenuBar meny;
	private JMenu arkiv;
	private JMenuItem clear, slumparad, öppna, spara, deleten, avsluta;
	private JTextArea t;
	private ControllerLyssnare l;
	public View() {
		//Skapar ett fönster och "skickar mig själv" som referens till klassen controller. Skapar en lyssnare till fönstret med hjälp av fönstermetoden addwindowListener.
		f = new JFrame("Lotto"); 
		l = new ControllerLyssnare(this);
		f.addWindowListener(l);
		
		//Skapar flera JMenuItems med olika namn och registrerar dem med en lyssnare. 
		meny = new JMenuBar();
		arkiv = new JMenu("Arkiv");
	
		clear = new JMenuItem("Clear");
		clear.setBackground(Color.red);
		clear.addActionListener(l);
		slumparad = new JMenuItem("Slumparad");
		slumparad.setBackground(Color.green);
		slumparad.addActionListener(l);
		öppna = new JMenuItem("Öppna");
		öppna.addActionListener(l);
		spara = new JMenuItem("Spara");
		spara.addActionListener(l);
		deleten = new JMenuItem("Delete");
		deleten.addActionListener(l);
		avsluta = new JMenuItem("Avsluta");
		avsluta.addActionListener(l);
		
		//Lägger till alla Jmenuitems i jMenu komponenten och därefter Jmenu komponenten i jMenu, för att dem ska synas på fönstret 
		arkiv.add(clear);
		arkiv.add(slumparad);
		arkiv.addSeparator();
		arkiv.add(öppna);
		arkiv.add(spara);
		arkiv.add(deleten);
		arkiv.addSeparator();
		arkiv.add(avsluta);
		
		meny.add(arkiv);
		
		//Skapar en jTextarea komponent med backgrundsfärg cyan och lägger till den i fönstret.
		t=new JTextArea();
		t.setBackground(Color.cyan);
		f.add(meny);
		f.add(t);
		f.setJMenuBar(meny);
	
		//Fönstret får ett mått på 200x200 och flyttas till 200 i båda x och y-led.
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
		
	}
	public static void main(String [] args) { //Main-funktionen skapar en instans av klassen View. Vilket gör så att det som finns i kontruktorn utförs. 
		new View();
	}
	
	public void Appendonscreen(String s) { //Funktionen tar emot en sträng och klistrar in den på JTextarean.
		t.append(s + "\n");	
	}
	public void Clearscreen() { //Funktionen rensar allt som finns på JTextarean med " ".
		t.setText(" ");
	}
	public JTextArea getTextarea() { //Funktionen returnerar referensen till JTextarea för att sedan kunna komma åt innehållet när man ska spara det i en fil.
		return t;
	}

}
