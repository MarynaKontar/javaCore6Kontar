package module11.IOGolovach15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by User on 16.05.2017.
 */
public class Test_person_many {
    public static void main(String[] args) throws IOException {
        //PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        for (int index = 0; index < 4; index++) {
            out.writePerson(new Person("Mike_" + index, index));
        }
        byte[] rawBytes = buff.toByteArray();

        EntityInput entityInput = new EntityInputStream(new ByteArrayInputStream(rawBytes));

        for (int index = 0; index < 4; index++) {
            //CALL
            Person person = entityInput.readPerson();
            //CHECK
            if (!person.getName().equals("Mike_" + index))
                throw new AssertionError();

            if (person.getAge() != index)
                throw new AssertionError();

        }

        System.out.println("OK");

//    int x = 9;//0000 0000 0000 1001
//    int y = 13;//0000 0000 0000 1101
//        int value = x << 4 | y; //0000 0000 1001 1101
//        System.out.println(value);
//
//        int shift = Integer.SIZE - 4;
//        int xValue = value >> 4; //0000 0000 0000 1001
//        System.out.println(xValue);
//        int yValue = (value << shift) >>> shift; //value << shift : 1101 0000 0000 0000;
//        // (value << shift) >>> shift: 0000 0000 0000 1101
//        System.out.println(yValue);


//        Integer yValue = v
    }
}
