package com.PostTracking.Models;

import java.util.ArrayList;
import java.util.List;

import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;

public class VehiclePaths {
    private Vehicle vehicle;
    private List<VehiclePath> paths;

    public VehiclePaths(Vehicle vehicle, List<Route> routes){
        this.vehicle = vehicle;
        createVehiclePath(routes, vehicle);
    }

    public void addVehiclePath(VehiclePath vehiclePath) {
        this.paths.add(vehiclePath);
    }

    private void createVehiclePath(List<Route> routes, Vehicle vehicle) {
        List<Route> filteredRoutes = filterRoutesByVehicle(routes, vehicle);
        // TODO Create each vehicle path.
    }

    private List<Route> filterRoutesByVehicle(List<Route> routes, Vehicle vehicle) {
        List<Route> filteredRoutes = new ArrayList<>();
        for (Route route : routes) {
            if(route.getVehicle().equals(vehicle)) {
                filteredRoutes.add(route);
            }
        }
        return filteredRoutes;
    }
}