package org.example.constant;

public interface ConstantMethods {
    static int getCardValue(String cardValue) {
        return switch (cardValue) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T" -> 10;
            default -> Integer.parseInt(cardValue);

//            default -> {
//                try {
//                    int parsedValue = Integer.parseInt(cardValue);
//                    if (parsedValue < 2 || parsedValue > 9) {
//                        System.out.println("Значение должно быть от 2 до 9 ");
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Неверный формат числа");
//                }
//
//            };
        };
    }

    static int getCardSuit(String cardSuit) {
        return switch (cardSuit) {
            case "C" -> 1;
            case "D" -> 2;
            case "H" -> 3;
            case "S" -> 4;
            default -> throw new IllegalArgumentException("Недопустимая масть карты: " + cardSuit);
        };
    }
}
