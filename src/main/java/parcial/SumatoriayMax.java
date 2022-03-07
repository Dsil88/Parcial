package parcial;

import dto.Productos;
import rx.Observable;
import rx.functions.Func2;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SilFr        // Problema 2 Sumatoria y valor MAX de los precios 
 */
public class SumatoriayMax {

    public static void main(String[] args) {
        List<Productos> producto = new ArrayList<>();

        Productos datoProducto = new Productos("ps4", 300);
        producto.add(datoProducto);

        producto.add(new Productos("gamecube", 300));
        producto.add(new Productos("eternal disk", 200));
        producto.add(new Productos("laptop", 800));
        producto.add(new Productos("vr", 230));
        // Se obtiene la sumatoria de los precios.
        Observable miobs1
                = Observable
                        .from(producto.toArray())
                        .map((result) -> {

                            Productos productos = (Productos) result;
                            return productos.getPrecio();
                        })
                        .reduce(
                            new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumulador, Integer actual) {
                            return acumulador + actual;
                            }
                        });

        miobs1.subscribe((sumatoria) -> {
            System.out.println("" + "Sumatoria:" + sumatoria);
        });
        // Parte donde se obtiene el valor máximo de los precios.

            Observable miObs2 = Observable.from(producto.toArray())
            .map((result) -> {

                    Productos productos = (Productos) result;
                    return productos.getPrecio();
                });
                MathObservable
                .max(miObs2)
                .subscribe((data) -> {
                    System.out.println("Result:" + data);
                });
    }
}
