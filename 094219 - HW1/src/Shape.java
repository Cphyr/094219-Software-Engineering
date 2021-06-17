public enum Shape {
    /**
     * enum of the types of cards
     */
    Clubs {
        public String toString() {
            return String.valueOf('\u2660');
        }
    },
    Diamonds {
        public String toString() {
            return String.valueOf('\u2666');
        }
    },
    Spades {
        public String toString() {
            return String.valueOf('\u2663');
        }
    },
    Hearts {
        public String toString() {
            return String.valueOf('\u2665');
        }
    }
}
