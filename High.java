import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class High extends JPanel{
    JButton high = new JButton("high");
    JButton low = new JButton("low");
    JButton next = new JButton("next game");
    JLabel t1 = new JLabel("5");
    JLabel t2 = new JLabel("?");
    JLabel t3 = new JLabel("judge");
    JLabel t4 = new JLabel("your money : 9 yen");
    JLabel t5 = new JLabel("bet : 1");
    JButton highbet = new JButton("bet +1yen");
    JButton lowbet = new JButton("bet -1yen");

    int number = 5;
    int money = 9;
    int bet = 1;

    boolean gameover = false;
    
    public High(){
	setLayout(null);
	add(high);
	high.setBounds(50, 150, 100, 30);
	add(low);
	low.setBounds(160, 150, 100, 30);
	add(next);
	next.setBounds(270, 150, 100, 30);
	add(t1);
	t1.setBounds(50, 50, 200, 30);
	add(t2);
	t2.setBounds(70, 50, 200, 30 );
	add(t3);
	t3.setBounds(100, 50, 200, 30);
	add(t4);
	t4.setBounds(50, 80, 200, 30);
	add(t5);
	t5.setBounds(50, 100, 200, 30);
	add(highbet);
	highbet.setBounds(270, 190, 100, 30);
	add(lowbet);
        lowbet.setBounds(270, 230, 100, 30);

	highbet.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt){
		    bet++;
		    money--;
		    t5.setText("bet :" + String.valueOf(bet));
		    t4.setText("your money : " + String.valueOf(money) + "yen");
		    if( bet < 0 || money <= 0 ){
			highbet.setEnabled(false);
		    }else{
			highbet.setEnabled(true);
			lowbet.setEnabled(true);
		    }
		}
	    });

        lowbet.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt){
		    bet--;
		    money++;
		    t5.setText("bet :" + String.valueOf(bet));
		    t4.setText("your money : " + String.valueOf(money) + "yen");
		    if( bet <= 0 || money <= 0 ){
			lowbet.setEnabled(false);
		    }else{
		        lowbet.setEnabled(true);
			highbet.setEnabled(true);
		    }

		}
	    });

	high.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt){
		    Random rand = new Random();
		    int randomInt = rand.nextInt(10);
		    t2.setText(String.valueOf(randomInt));
		    if( number < randomInt ){
			money = money + 2 * bet;
			t3.setText("you win" + String.valueOf(2*bet));
			bet = 1;
		    }else if( number > randomInt ){
			t3.setText("you lose");
			money = money - bet;
			bet = 1;
		    }else{
			t3.setText("draw");
			money = money + bet;
			bet = 1;
		    }
		    t5.setText("bet :" + String.valueOf(bet));
		    t4.setText("your money : " + String.valueOf(money) + "yen");
		    number = randomInt;
		    low.setEnabled(false);
		    high.setEnabled(false);
		    next.setEnabled(true);
		}
	    });

	low.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt){
		    Random rand2 = new Random();
		    int randomInt2 = rand2.nextInt(10);
		    t2.setText(String.valueOf(randomInt2));
		    if( number > randomInt2 ){
			money = money + 2 * bet;
			t3.setText("you win" + String.valueOf(2*bet));
			bet = 1;
		    }else if( number < randomInt2 ){
			t3.setText("you lose");
			//money = money - bet;
			bet = 1;
		    }else{
			t3.setText("draw");
			money = money + bet;
			bet = 1;
		    }
		    t5.setText("bet :" + String.valueOf(bet));
		    t4.setText("your money : " + String.valueOf(money) + "yen");
		    number = randomInt2;
		    low.setEnabled(false);
		    high.setEnabled(false);
		    next.setEnabled(true);
		}
	    });

	next.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt){
		    t1.setText(String.valueOf(number));
		    low.setEnabled(true);
		    high.setEnabled(true);
		    next.setEnabled(false);
		    highbet.setEnabled(true);
		    lowbet.setEnabled(true);

		    if( money <= 0 ){
			    gameover = true;
			    t4.setText("GameOver");
			}
		}
	    });
    }

    public static void main(String[] args) {
		JFrame app = new JFrame();
		app.add(new High());
		app.setSize(400, 300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	    }
}
