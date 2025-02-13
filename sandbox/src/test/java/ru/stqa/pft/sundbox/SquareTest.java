package ru.stqa.pft.sundbox;

import org.testng.annotations.Test;
import ru.sandbox.Square;

public class SquareTest {
  @Test
  public void testArea(){
    Square s = new Square(5);
    assert s.area() == 25;
  }
}
