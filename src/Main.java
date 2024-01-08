import Warehouse.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args){

    /* Warehouse.ProdottoFantoccio pippo = Warehouse.Warehouse.getProductFromPosition(1);
    System.out.println(pippo);
     */
    Warehouse.productIsStocked("bici","la magica", 99);

    Warehouse.productIsStocked("shampoo", "phantene", 2.44);
    Warehouse.productIsStocked("shampoo", "phantene", 2.44);
    Warehouse.productIsStocked("bici","la magica", 99);
    Warehouse.productIsStocked("shampoo", "phantene", 2.44);
   /*
    Warehouse.ProdottoFantoccio pippo2 = Warehouse.Warehouse.getProductFromPosition(2);
    System.out.println(pippo2);
    Warehouse.Warehouse.checkPositions();
    */
    ArrayList<Integer> pippo3 = Warehouse.checkProductByName("shampoo");
    System.out.println(pippo3);

  }
}
