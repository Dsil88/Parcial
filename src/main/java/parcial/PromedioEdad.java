/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial;

import dto.Persona;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.observables.MathObservable;

/**
 *
 * @author SilFr            //Problema 1: Promedio de edades personas  
 */
public class PromedioEdad {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Lucia", 30));
        personas.add(new Persona("Mario", 34));
        personas.add(new Persona("Javier", 18));
        personas.add(new Persona("Monica", 23));

        Observable<Persona> personObservable = Observable.from(personas);

        MathObservable
                .from(personObservable)
                .averageInteger(Persona::getEdad)
                .subscribe((promedio) -> {
                    System.out.println("PROMEDIO:" + promedio);
                });

    }
}
