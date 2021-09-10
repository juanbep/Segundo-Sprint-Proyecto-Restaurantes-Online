/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.restaurantathand.domain.entity.Dish;
import java.util.List;

/**
 * Interface que define los servicios de persistencia de platos del restaurante
 *
 * @author Beca98
 */
public interface IPlatoAccess {

    /**
     * Buscar un plato consumiendo un API REST
     *
     * @param prmIdDish ide del plato
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    public Dish findDish(String prmIdDish) throws Exception;

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
    public boolean updateDish(String prmIdDish, String prmNameDish, String prmPriceDish, String prmDescriptionDish, String prmTypeDish, String prmCategoriaDish) throws Exception;

    /**
     * Elimina un plato consumiendo un API REST mediante un plato jersey
     *
     * @param prmIdDish id del plato
     * @return true si se elimino correctamente el plato o false en caso
     * contrario
     * @throws Exception error al actualizar el plato
     */
    public boolean deleteDish(String prmIdDish) throws Exception;

    /**
     * Crea un plato consumiendo un API REST mediante un plato jersey
     *
     * @param dish plato del menu
     * @return Devuelve true si se pudo crear
     * @throws Exception error crear el usuario
     */
    public boolean createDish(Dish dish) throws Exception;

    /**
     * Lista todos los platos consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    public List<Dish> list() throws Exception;

}
