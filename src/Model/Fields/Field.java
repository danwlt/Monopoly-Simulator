package Model.Fields;

import Model.Bank;
import Model.GameHost;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Field {
    private final List<FieldObserver> observers = new ArrayList<>();
    final private Logger logger = Logger.getLogger(Field.class.getName());
    final private FieldType fieldType;
    final private String name;

    final private int position;

    public int getAmountOfVisitors() {
        return amountOfVisitors;
    }

    private int amountOfVisitors;

    public void addTotalCostOfVisiting(int costOfVisiting) {
        this.totalCostOfVisiting += costOfVisiting;
        logger.log(Level.INFO, String.format("%s has a total cost of %s for visitors", getName(), totalCostOfVisiting));
    }

    public void removeTotalCostOfVisiting(int bonusForVisiting) {
        this.totalCostOfVisiting -= bonusForVisiting;
        logger.log(Level.INFO, String.format("%s has a total cost of %s for visitors", getName(), totalCostOfVisiting));
    }

    private int totalCostOfVisiting;


    public Field(FieldType fieldType, String name, int position) {
        this.fieldType = fieldType;
        this.name = name;
        this.position = position;
        this.amountOfVisitors = 0;
        this.totalCostOfVisiting = 0;
    }

    public void visitedByPlayer(){
        amountOfVisitors++;
    }

    public void goToField(){
        goToField(true);
    }


    public void goToField(boolean checkForGo){
        if(checkForGo && GameHost.getCurrentPlayer().getPosition() > position){
            Bank.playerAdvancedGo();
        }
        GameHost.getCurrentPlayer().setPosition(position);
        executeAction();
    }

    protected abstract void executeAction();

    public int getPosition(){
        return position;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public String getName() {
        return name;
    }

    public void addObserver(FieldObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (FieldObserver observer : observers) {
            observer.fieldUpdated(this);
        }
    }
}
