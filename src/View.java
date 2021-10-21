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
	private JMenuItem clear, slumparad, �ppna, spara, deleten, avsluta;
	private JTextArea t;
	private ControllerLyssnare l;
	public View() {
		//Skapar ett f�nster och "skickar mig sj�lv" som referens till klassen controller. Skapar en lyssnare till f�nstret med hj�lp av f�nstermetoden addwindowListener.
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
		�ppna = new JMenuItem("�ppna");
		�ppna.addActionListener(l);
		spara = new JMenuItem("Spara");
		spara.addActionListener(l);
		deleten = new JMenuItem("Delete");
		deleten.addActionListener(l);
		avsluta = new JMenuItem("Avsluta");
		avsluta.addActionListener(l);
		
		//L�gger till alla Jmenuitems i jMenu komponenten och d�refter Jmenu komponenten i jMenu, f�r att dem ska synas p� f�nstret 
		arkiv.add(clear);
		arkiv.add(slumparad);
		arkiv.addSeparator();
		arkiv.add(�ppna);
		arkiv.add(spara);
		arkiv.add(deleten);
		arkiv.addSeparator();
		arkiv.add(avsluta);
		
		meny.add(arkiv);
		
		//Skapar en jTextarea komponent med backgrundsf�rg cyan och l�gger till den i f�nstret.
		t=new JTextArea();
		t.setBackground(Color.cyan);
		f.add(meny);
		f.add(t);
		f.setJMenuBar(meny);
	
		//F�nstret f�r ett m�tt p� 200x200 och flyttas till 200 i b�da x och y-led.
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
		
	}
	public static void main(String [] args) { //Main-funktionen skapar en instans av klassen View. Vilket g�r s� att det som finns i kontruktorn utf�rs. 
		new View();
	}
	
	public void Appendonscreen(String s) { //Funktionen tar emot en str�ng och klistrar in den p� JTextarean.
		t.append(s + "\n");	
	}
	public void Clearscreen() { //Funktionen rensar allt som finns p� JTextarean med " ".
		t.setText(" ");
	}
	public JTextArea getTextarea() { //Funktionen returnerar referensen till JTextarea f�r att sedan kunna komma �t inneh�llet n�r man ska spara det i en fil.
		return t;
	}

}
