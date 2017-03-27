package module8.homeWork8;

import module8.homeWork8.food.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static module8.homeWork8.Country.*;

/**
 * Java#6
 * Module 8 Task 4
 * Проверьте работу Manage System в классе Main (на примере 5+ продуктов).
 *
 * @author Kontar Maryna
 */
public class Main {
    public static void main ( String[] args ) {


        ManageSystem manageSystem = new ManageSystem ( );
        manageSystem.save ( new Eggs ( "Quail eggs", UKRAINE, 10 ), 23.0 );
        manageSystem.save ( new Bread ( "Rye bread", UKRAINE, 10 ), 23.0 );

        Map <Fruit, Double> fruitsDatabase = new HashMap <> ( );
        fruitsDatabase.put ( new Orange ( "Mini Oranges", ARGENTINA, 30 ), 28.0 );
        fruitsDatabase.put ( new Apple ( " Fuji", GEORGIA, 40 ), 21.0 );
        fruitsDatabase.put ( new Apple ( "Gala", LITHUANIA, 30 ), 14.0 );

        manageSystem.saveAll ( fruitsDatabase );

        System.out.println ( manageSystem.printDatabase ( ) );

        System.out.println (manageSystem.getProducts () );
        System.out.println (manageSystem.getPrices () );


    }
}
