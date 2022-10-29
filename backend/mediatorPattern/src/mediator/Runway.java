package mediator;

class Runway implements Command{
    private IAirTrafficControlMediator airTrafficControlMediator;
    public  Runway(IAirTrafficControlMediator airTrafficControlMediator){
        this.airTrafficControlMediator = airTrafficControlMediator;
        airTrafficControlMediator.setLandingStatus(true);
    }
    @Override
    public void land() {
        System.out.println("iniş izni verildi.");
        airTrafficControlMediator.setLandingStatus(true);
    }
}
