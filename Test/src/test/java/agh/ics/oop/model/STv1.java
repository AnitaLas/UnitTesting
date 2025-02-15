package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class STv1 {
    @Test
    void runTest() {

        // Pozycje startowe zwierzakow
        List<Vector2d> startingPos = List.of(
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
        String[] moves_0 = {};
        String[] moves_1 = {
                //3
                /*"f", "f", "r",
                "f", "b", "f",
                "l", "b", "b"*/

                // 4
                /*"f", "f", "r", "f",
                "f", "b", "f", "f",
                "l", "b", "b", "r"*/

                // 5
                /*"f", "f", "r", "f", "b",
                "f", "b", "f", "f", "b",
                "l", "b", "b", "r", "b"*/

                // 6
                /*"f", "f", "r", "f", "b", "r",
                "f", "b", "f", "f", "b", "r",
                "l", "b", "b", "r", "b", "f"*/

                // 7
                /*"f", "f", "r", "f", "b", "r", "f",
                "f", "b", "f", "f", "b", "r", "r",
                "l", "b", "b", "r", "b", "f", "b"*/


                //8
                /*"f", "f", "r", "f", "b", "r", "f", "r",
                "f", "b", "f", "f", "b", "r", "r", "r",
                "l", "b", "b", "r", "b", "f", "b", "f"*/

                //9
                /*"f", "f", "r", "f", "b", "r", "f", "r", "l",
                "f", "b", "f", "f", "b", "r", "r", "r", "f",
                "l", "b", "b", "r", "b", "f", "b", "f", "f"*/

                //10
                /*"f", "f", "r", "f", "b", "r", "f", "r", "l", "f",
                "f", "b", "f", "f", "b", "r", "r", "r", "f", "l",
                "l", "b", "b", "r", "b", "f", "b", "f", "f", "b"*/

                //11
                "f", "f", "r", "f", "b", "r", "f", "r", "l", "f", "r",
                "f", "b", "f", "f", "b", "r", "r", "r", "f", "l", "r",
                "l", "b", "b", "r", "b", "f", "b", "f", "f", "b", "b"
        };

        // finalne pozycje
        List<Vector2d> finalPos_0 = List.of(
                new Vector2d(2, 2), // N -> E
                new Vector2d(0, 4), // N -> N
                new Vector2d(4, 0),  // S -> E
                new Vector2d(2, 2),  // N- > W
                new Vector2d(2, 2),  // N -> N
                new Vector2d(2, 2),  // N -> S
                new Vector2d(0, 0),  //
                new Vector2d(0, 0),  //
                new Vector2d(1, 1), //
                new Vector2d(4, 0), //
                new Vector2d(0, 4)  //
        );
        List<Vector2d> finalPos_1 = List.of(
                new Vector2d(2, 4),
                new Vector2d(0, 2),
                new Vector2d(3, 0),
                new Vector2d(2, 4),
                new Vector2d(0, 0),
                new Vector2d(3, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 0),
                new Vector2d(0, 1),
                new Vector2d(3, 1),
                new Vector2d(20, 10)
        );

        // finalne orientacje
        List<MapDirection> finalOrient_0 = List.of(
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.NORTH,
                MapDirection.WEST,
                MapDirection.WEST,
                MapDirection.WEST,
                MapDirection.NORTH,
                MapDirection.NORTH
        );
        List<MapDirection> finalOrient_1 = List.of(
                MapDirection.WEST,
                MapDirection.NORTH,
                MapDirection.EAST,
                MapDirection.WEST,
                MapDirection.NORTH,
                MapDirection.SOUTH,
                MapDirection.SOUTH,
                MapDirection.EAST,
                MapDirection.SOUTH,
                MapDirection.NORTH,
                MapDirection.NORTH
        );


        Simulation sim_0 = new Simulation(startingPos, OptionsParser.zamiana(moves_0));
        Simulation sim_1 = new Simulation(startingPos, OptionsParser.zamiana(moves_1));


        sim_0.run();
        sim_1.run();

        // testy pozycji
        for (int i = 0; i < 2; i++) {
            assertEquals(finalPos_0.get(i), sim_0.getAnimalList().get(i).getPosition());
            assertEquals(finalPos_1.get(i), sim_1.getAnimalList().get(i).getPosition());

        }

        // testy orientacji
        for (int i = 0; i < 2; i++) {
            assertEquals(finalOrient_0.get(i), sim_0.getAnimalList().get(i).getOrientation());
            assertEquals(finalOrient_1.get(i), sim_1.getAnimalList().get(i).getOrientation());

        }

    }
}
