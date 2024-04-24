package Model;

import Model.Fields.Field;
import Model.Fields.Properties.Property_Field;
import Model.Fields.TradeableField;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
    private final List<PlayerObserver> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Player.class.getName());
    final private String name;
    private int position;
    private int balance;
    private boolean isInJail;
    private boolean isBankrupt;

    private boolean getOutOfJailCard;

    private final Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.isBankrupt = false;
        this.isInJail = false;
        this.balance = Bank.getStarterMoney();
        this.position = 0;
        this.color = color;

    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(int position) {
        Field currentField = PropertyManager.getFieldAtPosition(this.position);
        Field fieldToLandOn = PropertyManager.getFieldAtPosition(position);
        this.position = position;
        fieldToLandOn.notifyObservers();
        currentField.notifyObservers();
        notifyObservers();
    }

    public void addToPosition(int diceValue) {
        logger.log(Level.FINER, String.format("Adding %s fields to %s position", diceValue, GameHost.getCurrentPlayer().getName()));
        if (position + diceValue > 39){
            diceValue = diceValue - 40;
        } else if (position + diceValue < 0) {
            diceValue += 40;
        }
        Field fieldToLandOn = PropertyManager.getFieldAtPosition(this.position + diceValue);
        fieldToLandOn.goToField(true);
        notifyObservers();
    }

    public int getBalance() {
        return balance;
    }

    public void addToBalance(int addValue) {
        this.balance += addValue;
    }

    public void subtractBalance(int subtractValue) {
        this.balance -= subtractValue;
    }
    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt() {
        logger.log(Level.INFO, String.format("%s is bankrupt", GameHost.getCurrentPlayer().getName()));
        isBankrupt = true;
    }

    public boolean hasGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(boolean getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }

    //ToDo try to buy every property he can
    //ToDo try to buy houses
    //ToDo try to pay of mortgage
    public void investFunds(){
        Field currentField = PropertyManager.getFieldAtPosition(GameHost.getCurrentPlayer().getPosition());
        if (currentField instanceof TradeableField){
            ((TradeableField) currentField).buyProperty();
        }
        List<TradeableField> properties = PropertyManager.getPropertiesOfPlayer(GameHost.getCurrentPlayer(), PropertyManager::doesUserOwnGroup);
        for (TradeableField field: properties) {
            if (field instanceof Property_Field){
                ((Property_Field) field).buyHouse();
            }
        }
        properties = PropertyManager.getPropertiesOfPlayer(GameHost.getCurrentPlayer(), TradeableField::isMortgage);
        for (TradeableField field: properties) {
            field.payOffMortgage();
        }

    }

    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (PlayerObserver observer : observers) {
            observer.playerUpdated(this);
        }
    }
}
