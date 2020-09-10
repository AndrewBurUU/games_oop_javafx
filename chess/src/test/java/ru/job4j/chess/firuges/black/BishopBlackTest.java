package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        assertThat(bishopBlack.position(), is(Cell.F1));
    }

    @Test
    public void testRightUpWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.C1,Cell.G5),is(new Cell[] {Cell.D2,Cell.E3,Cell.F4,Cell.G5}));
    }

    @Test
    public void testRightDownWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        assertThat(bishopBlack.way(Cell.D4,Cell.G1),is(new Cell[] {Cell.E3,Cell.F2,Cell.G1}));
    }

    @Test
    public void testWayException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.C1,Cell.G4).toString(),is(
                String.format(
                        "Could not way by diagonal from C1 to G4"
                )));
    }

    public void testIsDiagonal() {
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        bishopBlack.copy(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }
}