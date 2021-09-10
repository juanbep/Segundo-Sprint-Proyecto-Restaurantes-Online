
package co.unicauca.plato.access;

import co.unicauca.plato.domain.entity.Dish;
import java.util.List;

/**
 *
 * @author Beca98
 */
public interface IPlatoRepository 
{
    List<Dish> findAll();

    Dish findByIdDish(String prmIdDish);

    boolean create(Dish prmNewDish);

    boolean update(Dish prmNewDish);

    boolean delete(String prmIdDish);
    
}
