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
    boolean gameOver = false;
    int turns = 0;

    public void setWinner(JButton button) {
        //button.setForeground(Color.green);
        button.setBackground(Color.green);
        textLabel.setText(currentPlayer + " is the winner!");
    }

    public void setTie(JButton button) {
        button.setBackground(Color.gray);
        textLabel.setText("Tie!");
    }
    
    public void checkWinner() {
        //horizontal
        for(int i = 0; i < 3; i++) {
            if(board[i][0].getText() == board[i][1].getText() && 
            board[i][1].getText() == board[i][2].getText() && board[i][0].getText() != "") {
                for(int j = 0; j < 3; j++) {
                    setWinner(board[i][j]);
                }
                gameOver = true;
                return;
            } 
        }
        //vertical
        for(int j = 0; j < 3; j++) {
            if(board[0][j].getText() == board[1][j].getText() &&
            board[1][j].getText() == board[2][j].getText() && board[0][j].getText() != "") {
                for(int i = 0; i < 3; i++) {
                    setWinner(board[i][j]);
                }
                gameOver = true;
                return;
            }
        }
        //diagonal
        if(board[0][0].getText() == board[1][1].getText() &&
        board[1][1].getText() == board[2][2].getText() && board[0][0].getText() != "") {
            for(int i = 0; i < 3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }
        //anti-diagonal
        if(board[0][2].getText() == board[1][1].getText() &&
        board[1][1].getText() == board[2][0].getText() && board[0][2].getText() != "") {
            for(int i = 0; i < 3; i++) {
                setWinner(board[i][2-i]);
            }
            gameOver = true;
            return;
        }
        //tie
        if(turns == 9) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    setTie(board[i][j]);
                }
            }
            gameOver = true;
        }
    }

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBackground(Color.pink);
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
                tile.setBackground(Color.pink);
                tile.setForeground(Color.white);
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == "") {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if(gameOver) return;
                            currentPlayer = currentPlayer == playerX? playerO : playerX;
                            textLabel.setText(currentPlayer + "'s turn");
                        }
                    }
                    
                    
                });
            }
        } while(true) {
            
        }

    }

    
}
