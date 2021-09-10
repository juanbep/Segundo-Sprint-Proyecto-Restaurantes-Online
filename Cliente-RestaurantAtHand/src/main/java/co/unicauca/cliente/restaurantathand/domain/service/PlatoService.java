/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente.restaurantathand.domain.service;

import co.unicauca.cliente.restaurantathand.access.IPlatoAccess;
import co.unicauca.cliente.restaurantathand.domain.entity.Dish;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Luis Tabares
 */
public class PlatoService {

    private final IPlatoAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IPlatoAccess
     */
    public PlatoService(IPlatoAccess service) {
        this.service = service;
    }

    /**
     * Busca un plato en el servidor remoto
     *
     * @param prmIdDish id del plato
     * @return Objeto tipo plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Dish findDish(String prmIdDish) throws Exception {
        return service.findDish(prmIdDish);

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
    public Dish findDish(String prmIdDish, String prmNameDish, String prmPriceDish, String prmDescriptionDish, String prmTypeDish, String prmCategoriaDish) throws Exception {
        return service.findDish(prmIdDish);

    }

    /**
     * Creacion de un plato
     *
     * @param dish
     * @return
     * @throws Exception
     */
    public boolean createDish(Dish dish) throws Exception {
        return service.createDish(dish);

    }

}
