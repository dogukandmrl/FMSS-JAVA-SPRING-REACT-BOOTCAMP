package mediator;

class mediatorPattern {
    public static void main(String[] args) {
    IAirTrafficControlMediator airTrafficControl = new AirTrafficControl();
    Flight sparrow101 = new Flight(airTrafficControl);
    Runway mainRunway = new Runway(airTrafficControl);
    airTrafficControl.registerFlight(sparrow101);
    sparrow101.getReady();
    mainRunway.land();
    sparrow101.land();
    }
}
