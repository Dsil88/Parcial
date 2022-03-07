/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.MathObservable;

/**
 *
 * @author SilFr          Problema 3: Promedio, Sumatoria y Filtrado de datos
 */     
public class Problema3 {

    public static void main(String[] args) {
        Integer[] num = {2, 5, 6, 8, 10, 35, 2, 10}; 

        Observable<Integer> miObs = Observable.from(num);

        // Aqui se obtiene el promedio de los valores
        
        Observable prom
                = miObs
                        .map((item) -> {
                            return item.doubleValue();
                        });
        MathObservable
                .averageDouble(prom)
                .subscribe((promedio) -> {
                    System.out.println("promedio:" + promedio);
                });

        // Aqui se obtiene la sumatoria de los valores
        Observable sumatoria
                = miObs
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumulador, Integer actual) {
                                return acumulador + actual;
                            }
                        });
        sumatoria.subscribe((sum) -> {
            System.out.println("" + "Sumatoria:" + sum);
        });
            
        //filtro de valores mayores o iguales a 10:
        
        System.out.println("Valores mayores o iguales a 10: ");
        Observable
                .from(num)
                .filter(
                        new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer t) {
                        return t >= 10;
                    }
                }// ordenamiento
                )
                .subscribe((valor) -> {
                    
                    System.out.println(valor);
                });
    }

}
