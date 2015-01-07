package uy.infocorp.banking.glass.domain.gesture;

public class SwipeGestureUtils {

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
}
