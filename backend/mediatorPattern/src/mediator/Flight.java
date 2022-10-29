package mediator;

class Flight implements Command{
    private IAirTrafficControlMediator airTrafficControl;
    public  Flight(IAirTrafficControlMediator airTrafficControlMediator)
    {
        this.airTrafficControl = airTrafficControlMediator;

    }
    @Override
    public void land() {
        if(airTrafficControl.islandingOk()){
            System.out.println("inis basarili");
            airTrafficControl.setLandingStatus(true);

        }
        else{
            System.out.println("inis icin bekleyin");
        }
    }
    public void getReady(){
        System.out.println("inis icin hazir");
    }
}
