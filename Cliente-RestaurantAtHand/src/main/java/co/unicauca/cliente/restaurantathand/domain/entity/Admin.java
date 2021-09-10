/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente.restaurantathand.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class Admin extends User {

    private List<Restaurant> restaurants;

    public Admin() {
        restaurants = new ArrayList<Restaurant>();
    }

    public Admin(String atrUserName, String atrIdentification, String atrName, String atrLastName, String atrContrasena, String atrCiudad, String atrDireccion, String atrCelular, String atrTipo) {
        super(atrUserName, atrIdentification, atrName, atrLastName, atrContrasena, atrCiudad, atrDireccion, atrCelular, atrTipo);
        restaurants = new ArrayList<Restaurant>();
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);

    }
}
