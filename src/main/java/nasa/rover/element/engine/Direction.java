package nasa.rover.element.engine;

public enum Direction {
    N("NORTH") {
        @Override
        public Direction atRight() {
            return E;
        }

        @Override
        public Direction atLeft() {
            return W;
        }

    },

    E("EAST") {
        @Override
        public Direction atRight() {
            return S;
        }

        @Override
        public Direction atLeft() {
            return N;
        }

    },

    S("SOUTH") {
        @Override
        public Direction atRight() {
            return W;
        }

        @Override
        public Direction atLeft() {
            return E;
        }

    },

    W("WEST") {
        @Override
        public Direction atRight() {
            return N;
        }

        @Override
        public Direction atLeft() {
            return S;
        }

    };

    private final String direction;

    private Direction(String direction) {
        this.direction = direction;
    }

    /**
     * NOT USED !! This method is override in each ENUM
     */
    public Direction atRight() {
        return null;
    };

    /**
     * NOT USED !! This method is override in each ENUM
     */
    public Direction atLeft() {
        return null;
    };

}
