package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsParserTest {

    @Test
    void zamianaTest() {

        // Pozycje startowe zwierzakow
        List<Vector2d> animalsStatrPos = List.of(
                new Vector2d(2, 2),
                new Vector2d(0, 4),
                new Vector2d(4, 0),
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(1, 1),
                new Vector2d(4, 0),
                new Vector2d(0, 4)

        );

        // ruchy (kazda kolumna to ruchy jednego zwierzaka)
        String[] moves_1 = {
                "f", "f", "r", "f", "b", "r", "f", "r", "l", "f", "r",
                "f", "b", "f", "f", "b", "r", "r", "r", "f", "l", "r",
                "l", "b", "b", "r", "b", "f", "b", "f", "f", "b", "b"
        };

        List<String[]> actualMove1 = List.of(
                new String[]{"f", "f", "l"},
                new String[]{"f", "b", "b"},
                new String[]{"r", "f", "b"},
                new String[]{"f", "f", "r"},
                new String[]{"b", "b", "b"},
                new String[]{"r", "r", "f"},
                new String[]{"f", "r", "b"},
                new String[]{"r", "r", "f"},
                new String[]{"l", "f", "f"},
                new String[]{"f", "l", "b"},
                new String[]{"r", "r", "b"}
        );

        /*List<String[]> actualMove1 = List.of(
                "f", "f", "l";
                "f", "b", "b";
                {"r", "f", "b"}
                {"f", "f", "r"}
                {"b", "b", "b"}
                {"r", "r", "f"}
               {"f", "r", "b"}
                {"r", "r", "f"}
                {"l", "f", "f"}
                {"f", "l", "b"}
                {"r", "r", "b"}
        );*/


        List<MoveDirection[]> expectedMoves1 = List.of(
                new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT},
                new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD},
                new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD},
                new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT},

                new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD},
                new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD},
                new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD},
                new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD},

                new MoveDirection[] {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD},
                new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD},
                new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD}
        );

        for (int i = 0; i < animalsStatrPos.size(); i++) {
            Animal animal1 = new Animal(animalsStatrPos.get(i));
            Animal animal2 = new Animal(animalsStatrPos.get(i));


            System.out.println();
            System.out.println("---------------------- animal = " + i);
           // for (int j = 0; j < expectedMoves1.size(); j++) {

                MoveDirection[] expectedAnimalMoves = expectedMoves1.get(i);
                String[] actualMove = actualMove1.get(i);

                //assertEquals(animal1.isAt(animalsStatrPos.get(j)), animal2.isAt(animalsStatrPos.get(j)));

                for (int z = 0; z < expectedAnimalMoves.length; z++) {

                    animal1.move(expectedAnimalMoves[z]);
                    System.out.println("expectedAnimalMoves[z] = " + expectedAnimalMoves[z]);

                    //String[] oneMove = new String[] {actualMove};

                    String[] oneMove = new String[]{actualMove[z]};
                    //OptionsParser.zamiana(oneMove);

                    animal2.move(OptionsParser.zamiana(oneMove).get(0));

                    System.out.println("OptionsParser.zamiana(oneMove).get(0) = " + OptionsParser.zamiana(oneMove).get(0));

                    assertEquals(animal1.isAt(animalsStatrPos.get(i)), animal2.isAt(animalsStatrPos.get(i)));
                    assertEquals(animal1.getPosition(), animal2.getPosition());
                    assertEquals(animal1.getOrientation(), animal2.getOrientation());
                    //System.out.println(animal1.getPosition());
                    //System.out.println(animal2.getPosition());
                }



         //   }







        }


        // given by teacher
       /* String[] input1 = new String[]{"f", "f"};
        MoveDirection[] output1_animalMove = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD};

        List<MoveDirection> output1 = Arrays.asList(output1_animalMove);

        String[] input2 = new String[]{"f"};
        MoveDirection[] output2_animalMove = new MoveDirection[] {MoveDirection.FORWARD};

        List<MoveDirection> output1a = Arrays.asList(output2_animalMove);
        //assertEquals(output1a, OptionsParser.zamiana(input2));
        List<MoveDirection> listaZmiana = OptionsParser.zamiana(input2);
        //List<MoveDirection> listaZmiana = OptionsParser.zamiana(moves_1);*/



        /*for (int i = 0; i < animalsStatrPos.size(); i++) {
            Animal animal1 = new Animal(animalsStatrPos.get(i));
            Animal animal2 = new Animal(animalsStatrPos.get(i));


            System.out.println();
            System.out.println("---------------------- animal = " + i);
            for (int j = 0; j < expectedMoves1.size(); j++) {

                MoveDirection[] expectedAnimalMoves = expectedMoves1.get(j);
                String[] actualMove = actualMove1.get(j);

                assertEquals(animal1.isAt(animalsStatrPos.get(j)), animal2.isAt(animalsStatrPos.get(j)));

                for (int z = 0; z < expectedAnimalMoves.length; z++) {

                    animal1.move(expectedAnimalMoves[z]);
                    System.out.println("expectedAnimalMoves[z] = " + expectedAnimalMoves[z]);

                    //String[] oneMove = new String[] {actualMove};

                    String[] oneMove = new String[]{actualMove[z]};
                    //OptionsParser.zamiana(oneMove);

                    animal2.move(OptionsParser.zamiana(oneMove).get(0));

                    System.out.println("OptionsParser.zamiana(oneMove).get(0) = " + OptionsParser.zamiana(oneMove).get(0));

                    assertEquals(animal1.isAt(animalsStatrPos.get(j)), animal2.isAt(animalsStatrPos.get(j)));
                   // assertEquals(animal1.getPosition(), animal2.getPosition());
                    //assertEquals(animal1.getOrientation(), animal2.getOrientation());
                    //System.out.println(animal1.getPosition());
                    //System.out.println(animal2.getPosition());
                }



           }







        }*/



        /*Animal animal = new Animal(animalsStatrPos.get(0));
        Animal animal2 = new Animal(animalsStatrPos.get(0));
        List<MoveDirection> listaZmiana = OptionsParser.zamiana(input2);

        animal.move(output2_animalMove[0]);
        animal.isAt(animalsStatrPos.get(0));

        animal2.move(listaZmiana.get(0));
        animal2.isAt(animalsStatrPos.get(0));

        assertEquals(animal.isAt(animalsStatrPos.get(0)), animal2.isAt(animalsStatrPos.get(0)));
        assertEquals(animal.getPosition(), animal2.getPosition());
        System.out.println(animal.getPosition());
        System.out.println(animal2.getPosition());*/




        /*Animal animal1 = new Animal(animalsStatrPos.get(0));
        Animal animal2 = new Animal(animalsStatrPos.get(0));

        animal1.move(output2_animalMove[0]);
        animal2.move(listaZmiana.get(0));


        for (int i = 0; i < output2_animalMove.length; i++) {

            assertEquals(animal1.isAt(animalsStatrPos.get(i)), animal2.isAt(animalsStatrPos.get(i)));
            assertEquals(animal1.getPosition(), animal2.getPosition());
            assertEquals(animal1.getOrientation(), animal2.getOrientation());
            System.out.println(animal1.getPosition());
            System.out.println(animal2.getPosition());
        }*/

//animal.move(output1_animalMove[i]);






        //Animal animal = new Animal();
        //animal.move(output1_s[0]);


        //assertEquals(MoveDirection.FORWARD, OptionsParser.zamiana(input1));

       // String[] input1 = new String[]{"f", "f"};

        /*String[] values = new String[]{
                "f", "f", "r", "f", "b", "r", "f", "r", "l", "f", "r",
                "f", "b", "f", "f", "b", "r", "r", "r", "f", "l", "r",
                "l", "b", "b", "r", "b", "f", "b", "f", "f", "b", "b"};*/

        //ArrayList<MoveDirection> output1 = new ArrayList<>();]



        // my update v1
        /*String[] values = new String[]{"f", "b", "r", "l"};

        // String[] values = new String[]{"f", "f", "l"};


        int i = 0;
        for (MoveDirection moveDirection : MoveDirection.values()) {


            System.out.println(">" + moveDirection);

            String value = values[i];
            String[] input1 = new String[]{value, value};
            MoveDirection[] output1_s = new MoveDirection[]{moveDirection, moveDirection};
            List<MoveDirection> output1 = Arrays.asList(output1_s);
            assertEquals(output1, OptionsParser.zamiana(input1));

            i++;



        }*/






    }
}