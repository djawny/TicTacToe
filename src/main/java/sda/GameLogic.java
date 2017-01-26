package sda;

import javax.swing.*;

public class GameLogic {
    public boolean checkWinCondition(JButton[][] gameBoardButtons) {

        for (int i = 0; i < gameBoardButtons.length; i++) {
            if (checkColumnForWinning(gameBoardButtons[i]) || checkRowForWinning(gameBoardButtons, i)) {
                return true;
            }
        }
        return checkDiagonals(gameBoardButtons);
    }

    private boolean checkColumnForWinning(JButton[] gameBoardButtons) {
        return (gameBoardButtons[0].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[1].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[2].getText().equals(Mark.TIC.toString()))
                || (gameBoardButtons[0].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[1].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[2].getText().equals(Mark.TOE.toString()));
    }

    private boolean checkRowForWinning(JButton[][] gameBoardButtons, int columnIndex) {
        return (gameBoardButtons[0][columnIndex].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[1][columnIndex].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[2][columnIndex].getText().equals(Mark.TIC.toString()))
                || (gameBoardButtons[0][columnIndex].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[1][columnIndex].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[2][columnIndex].getText().equals(Mark.TOE.toString()));
    }

    private boolean checkDiagonals(JButton[][] gameBoardButtons) {
        return (gameBoardButtons[0][0].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[1][1].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[2][2].getText().equals(Mark.TIC.toString()))
                || (gameBoardButtons[0][0].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[1][1].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[2][2].getText().equals(Mark.TOE.toString()))
                || (gameBoardButtons[0][2].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[1][1].getText().equals(Mark.TOE.toString())
                && gameBoardButtons[2][0].getText().equals(Mark.TOE.toString()))
                || (gameBoardButtons[0][2].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[1][1].getText().equals(Mark.TIC.toString())
                && gameBoardButtons[2][0].getText().equals(Mark.TIC.toString()));
    }
}
