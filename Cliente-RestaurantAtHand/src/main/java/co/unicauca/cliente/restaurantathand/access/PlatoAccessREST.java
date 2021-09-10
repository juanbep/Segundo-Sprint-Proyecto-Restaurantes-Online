/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.PlatoJerseyClient;
import co.unicauca.cliente.restaurantathand.domain.entity.Dish;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para Plato(Dish)
 *
 * @author Luis Tabares
 */
public class PlatoAccessREST implements IPlatoAccess {

    PlatoJerseyClient jersey;
    Response rta;

    public PlatoAccessREST() {
        this.jersey = new PlatoJerseyClient();
    }

    /**
     * Buscar un plato consumiendo un API REST mediante un plato jersey
     *
     * @param prmIdDish id del plato
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    @Override
    public Dish findDish(String prmIdDish) throws Exception {
        Dish dish = jersey.findByIdDish_JSON(Dish.class, prmIdDish);
        return dish;
    }

    /**
     *
     * @param prmIdDish id del plato
     * @param prmNameDish nombre del plato
     * @param prmPriceDish precio del plato
     * @param prmDescriptionDish descripcion del plato
     * @param prmTypeDish tipo de plato(Especial , Del dia)
     * @param prmCategoriaDish categoria del plato(Entradas,Platos
     * fuertes,Ensaladas,Postres,Bebidas)
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean updateDish(String prmIdDish, String prmNameDish, String prmPriceDish, String prmDescriptionDish, String prmTypeDish, String prmCategoriaDish) throws Exception {
        Dish dish = findDish(prmIdDish);
        if (dish == null) {
            return false;
        }
        dish.setAtrIdDish(prmIdDish);
        dish.setAtrNameDish(prmNameDish);
        dish.setAtrPriceDish(prmPriceDish);
        dish.setAtrDescriptionDish(prmDescriptionDish);
        dish.setAtrTypeDish(prmTypeDish);
        dish.setAtrCategoriaDish(prmCategoriaDish);

        rta = jersey.edit_JSON(dish, prmIdDish);
        return true;
    }

    /**
     * Elimina un plato consumiendo un API REST mediante un plato jersey
     *
     * @param prmIdDish id del plato
     * @return true si se elimino correctamente el plato o false en caso
     * contrario
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean deleteDish(String prmIdDish) throws Exception {
        Dish dish = findDish(prmIdDish);
        if (dish == null) {
            return false;
        }
        rta = jersey.delete(prmIdDish);
        return true;
    }

    /**
     * Crea un plato consumiendo un API REST mediante un plato jersey
     *
     * @param dish plato del menu
     * @return Devuelve true si se pudo crear
     * @throws Exception error crear el usuario
     */
    @Override
    public boolean createDish(Dish dish) throws Exception {
        Dish dishes = findDish(dish.getAtrIdDish());
        if (dishes != null) {
            return false;
        }
        rta = jersey.create_JSON(dish);
        return true;
    }

    /**
     * Lista todos los platos consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    @Override
    public List<Dish> list() throws Exception {
        GenericType<List<Dish>> listResponseTypeM = new GenericType<List<Dish>>() {
        };
        List<Dish> user = jersey.findAll(listResponseTypeM);
        return user;
    }

}
