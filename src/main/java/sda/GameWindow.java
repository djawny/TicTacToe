package sda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

public class GameWindow extends JFrame implements ActionListener {
    private static final int BOARD_WIDTH = 3;
    private static final int BOARD_HEIGHT = 3;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Kółko i Krzyżyk - Daniel Jawny";
    private JButton[][] gameBoardButtons = new JButton[BOARD_WIDTH][BOARD_HEIGHT];
    private GameLogic gameLogic;
    private int markCount;

    GameWindow() throws HeadlessException {
        markCount = 0;
        gameLogic = new GameLogic();
        setLayout(null);
        setBackground(new Color(49, 111, 122));
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        createGameBoardButtons();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createGameBoardButtons() {
        int gameBoardButtonSize = 90;
        Font buttonFont = new Font("Arial", Font.PLAIN, 50);
        IntStream.range(0, gameBoardButtons.length).forEach(i ->
                IntStream.range(0, gameBoardButtons[i].length).forEach(j -> {
                    gameBoardButtons[i][j] = new JButton();
                    gameBoardButtons[i][j].setLocation(250 + i * gameBoardButtonSize, 100 + j * gameBoardButtonSize);
                    gameBoardButtons[i][j].setSize(gameBoardButtonSize, gameBoardButtonSize);
                    gameBoardButtons[i][j].setFont(buttonFont);
                    gameBoardButtons[i][j].setBackground(new Color(21, 85, 163));
                    gameBoardButtons[i][j].addActionListener(this);
                    add(gameBoardButtons[i][j]);
                })
        );
    }

    private void markButton(ActionEvent e, Character mark) {
        IntStream.range(0, gameBoardButtons.length).forEach(i ->
                IntStream.range(0, gameBoardButtons[i].length).forEach(j -> {
                    if (e.getSource() == gameBoardButtons[i][j]) {
                        gameBoardButtons[i][j].setText(Character.toString(mark));
                        gameBoardButtons[i][j].setBackground(new Color(49, 74, 122));
                        gameBoardButtons[i][j].setEnabled(false);
                    }
                })
        );
    }

    private void showEndDialogs(String messageDialogText) {
        Object[] questionOptions = {"Tak", "Nie"};
        JOptionPane.showMessageDialog(null, messageDialogText, "Wiadomość:", JOptionPane.INFORMATION_MESSAGE);
        int endOption = JOptionPane.showOptionDialog(null, "Czy chcesz zagrać jeszcze raz?", "Pytanie:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, questionOptions, questionOptions[0]);
        if (endOption == 0) {
            setVisible(false);
            dispose();
            new GameWindow();
        } else {
            System.exit(0);
        }
    }

    private Mark chooseMark() {
        return (markCount % 2 == 0) ? Mark.TIC : Mark.TOE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        markCount++;
        Mark mark = chooseMark();
        markButton(e, mark.getCharMark());
        if (gameLogic.checkWinCondition(gameBoardButtons)) {
            showEndDialogs("Gracz ze znakiem '" + mark + "' wygrywa!");
        } else if (markCount == 9) {
            showEndDialogs("Remis, żaden gracz nie wygrywa!");
        }
    }
}
