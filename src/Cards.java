import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cards extends JFrame implements ActionListener{
	private JButton hit;
	private JButton stay;
	private JLabel scores;
	int total;
	int house;
	boolean hits;
	boolean continueGame;
	private JLabel WL;
	
	public Cards() {
		setValues();
		getContentPane().setBackground(Color.GREEN);
		setLayout(null);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WL = new JLabel("");
		scores = new JLabel("Dealer hand: " + "0" + "     " + "Your hand: " + "0");
		hit = new JButton("Hit");
		stay = new JButton("Stay");
		WL.setBounds(325, 300, 400, 100);
		WL.setFont(new Font("Comic Sans", Font.BOLD, 40));
		scores.setBounds(250, 0, 400, 100);
		scores.setFont(new Font("Comic Sans", Font.BOLD, 20));
		hit.setBounds(300, 450, 200, 50);
		stay.setBounds(300, 550, 200, 50);
		hit.addActionListener(this);
		stay.addActionListener(this);
		add(WL);
		add(hit);
		add(stay);
		add(scores);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(total <= 21) {
			if(e.getSource() == hit) {
				int newCard = drawCard();
	            total += newCard;
	            scores.setText("Dealer hand: " + house + "     " + "Your hand: " + total);
	            if(total > 21) {
	            	scores.setText("Dealer hand: " + house + "     " + "Your hand: " + total);
	            	checkWin();
	            	
	            }
			}
			if(e.getSource() == stay) {
				if(total <= 21) {
		            houseGetCards();
		            scores.setText("Dealer hand: " + house + "     " + "Your hand: " + total);
		        }
				checkWin();
			}
		}
	}
	
	public static void main(String args[]) {
		Cards g = new Cards();
		g.setVisible(true);
	}
	
	void checkWin() {
        if ((total > house && total <= 21) || house > 21) {
        	WL.setText("WINNER");
        } 
        if ((total < house && house <= 21) || total > 21) {
        	WL.setText("LOSER");
        } 
        if (total == house || (total > 21 && house > 21)) {
        	WL.setText("DRAW");
        }
    }
	
	void houseGetCards() {
        while(house < 17) {
            int newCard = drawCard();
            house+= newCard;
        }
    }
	
	int drawCard() {
        int newCard = (int) ((Math.random()* 10) + 1);
        if (newCard == 1) {
            newCard = 11;
            if(total + newCard > 21) {
                newCard = 1;
            }
        }
        return newCard;
    }
	
	void setValues() {
        total = (int) ((Math.random()* 10) + 1);
        house = (int) ((Math.random()* 10) + 1);
        continueGame = true;
    }

}