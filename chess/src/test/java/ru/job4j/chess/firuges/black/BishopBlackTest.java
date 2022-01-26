package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(C1);
        Assert.assertEquals(bishop.position(), C1);
        }

    @Test
    public void testCopy() {
        BishopBlack bishop = new BishopBlack(C1);
        Assert.assertEquals(bishop.copy(F4).position(), F4);
    }

    @Test
    public void whenWay() {
        BishopBlack bhb = new BishopBlack(C8);
        Cell[] result = bhb.way(F5);
        Cell[] expect = {D7, E6, F5};
        Assert.assertEquals(result, expect);
    }
}