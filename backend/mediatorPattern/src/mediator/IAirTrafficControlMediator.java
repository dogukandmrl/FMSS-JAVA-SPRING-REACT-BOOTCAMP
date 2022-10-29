package mediator;

interface IAirTrafficControlMediator {
    public void registerRunway(Runway runway);
    public void registerFlight(Flight flight);
    public boolean islandingOk();
    public void setLandingStatus(boolean status);

}
