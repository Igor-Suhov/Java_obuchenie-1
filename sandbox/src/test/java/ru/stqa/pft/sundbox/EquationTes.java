package ru.stqa.pft.sundbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTes {
  @Test
  public void test0(){
    Equation e=new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);

  }
  @Test
  public void test1(){
    Equation e=new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);

  }
  @Test
  public void test2(){
    Equation e=new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);

  }
}

