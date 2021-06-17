public class Card
{
    /**
     * Defines a single game card
     * num:
     *      type - int
     *      range - [1, 13]
     * shape:
     *      type - Shape
     */

    private final int num;
    private final Shape shape;

    public Card(int aNum, Shape aShape) {
        /**
         * @param   aNum    (int) the number of the card.
         *                  from 1 to 13 (inclusive).
         * @param   aShape  (Shape) the shape of the card
         * @since   1.0
         */
        num = aNum;
        shape = aShape;
    }

    public int getNum() {
        /**
         * @return  the number of the card
         * @since   1.0
         */
        return num;
    }

    public Shape getShape() {
        /**
         * @return  the shape of the card
         * @since   1.0
         */
        return shape;
    }

    public int compare(Card other) {
        /**
         * @param other - Card() to compere to.
         * @return:
         *      0 - if the num of this equals to the num of other
         *      1 - if the num of this larger than the num of other
         *      -1 - if the num of this smaller than the num of other
         *
         * @since 1.0
         */
        if (num == other.num)
            return 0;

        return num > other.num ? 1 : -1;

    }

    public String toString() {
        /**
         * @return  string of format: val of shape(emoji)
         * @since   1.0
         */
        String msg;
        switch (num){
            case 1:
                msg="Ace";
                break;
            case 11:
                msg="Jack";
                break;
            case 12:
                msg="Queen";
                break;
            case 13:
                msg="King";
                break;
            default:
                msg=String.valueOf(num);
        }
        return msg + " of " + shape.toString();
    }
}
