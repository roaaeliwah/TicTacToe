import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe {
    int boardWidth = 500;
    int boardHeight = 550;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new  JButton[3][3];
    String playerX = "X";
    String playerO = "O";

    String currentPlayer = playerX;

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBackground(Color.black);
        textLabel.setForeground(Color.white);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        frame.add(boardPanel);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                board[i][j] = tile;
                boardPanel.add(tile);
                tile.setFont(new Font("Arial", Font.BOLD, 50));
                tile.setBackground(Color.black);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == "") {
                            tile.setText(currentPlayer);
                            currentPlayer = currentPlayer == playerX? playerO : playerX;
                            textLabel.setText(currentPlayer + "'s turn");
                        }
                    }
                    
                    
                });
            }
        }

    }

    
}
