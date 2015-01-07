package uy.infocorp.banking.glass.domain.gesture;

public class SwipeGestureUtils {

    private static final int MAX_AMOUNT = 10000;
    private static final int MIN_AMOUNT = 0;

    public static int calculateNewAmountFromSwipe(float displacement, int amount) {
        if (displacement > 500) {
            amount += 1000;
        }
        else if (displacement > 250) {
            amount += 500;
        }
        else if (displacement > 50) {
            amount += 100;
        }
        else if (displacement < -500) {
            amount -= 1000;
        }
        else if (displacement < -250) {
            amount -= 500;
        }
        else if (displacement < -50) {
            amount -= 100;
        }

        return amount;
    }

    public static String amountToDisplay(int amount) {
        if (amount > MAX_AMOUNT) {
            amount = MAX_AMOUNT;
        } else if (amount < MIN_AMOUNT) {
            amount = MIN_AMOUNT;
        }

        return String.valueOf(amount);
    }
}
