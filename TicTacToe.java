import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame{

	JButton[][] board = new JButton[3][3];
	char player = 'X';
	JButton square = new JButton("Square");
	JButton newGame = new JButton("New Game");
	JTextField wins = new JTextField(4);
	JTextField status = new JTextField(10);
	JPanel controlPanel = new JPanel();
	GridLayout grid = new GridLayout(4,3);
	JPanel boardPanel = new JPanel();
	
	
	public TicTacToe(){
		setTitle("Tic Tac Toe");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout (new BorderLayout());
		
		boardPanel.setLayout(new GridLayout(3,3));
		for (int r = 0; r<3; r++)
			for( int c = 0; c<3; c++){
				board[r][c] = new JButton("");
				board[r][c].addActionListener(new SquareListener(r,c));
				boardPanel.add(board[r][c]);
			}
		add(boardPanel,BorderLayout.CENTER);
		newGame.addActionListener(new NewGameListener());
		//controlPanel.add(square);
		controlPanel.add(newGame);
		controlPanel.add(wins);
		controlPanel.add(status);
		
		add(controlPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	class SquareListener implements ActionListener {
		int row, col;
		boolean taken = false;
		public SquareListener(int r, int c) {
			row = r;
			col = c;
		}
		public void actionPerformed(ActionEvent e) {
			if (taken) return;
			System.out.println( player + " gets this square");
			taken = true;
			board[row][col].setText("" + player);
			if (player == 'X')
				player = 'O';
			else
				player = 'X';
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Tic-Tac-Toe is starting now ");
		TicTacToe game;
		game = new TicTacToe();
		
	}
}
