package sda;

import javax.swing.*;
import java.util.stream.IntStream;

public class GameLogic {
    public boolean checkWinCondition(JButton[][] gameBoardButtons) {
        return IntStream
                .range(0, gameBoardButtons.length)
                .filter(i -> checkColumnForWinning(gameBoardButtons[i]) || checkRowForWinning(gameBoardButtons, i))
                .findAny()
                .isPresent()
                || checkDiagonals(gameBoardButtons);
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
