public enum Tipo {
        ADMIN(1), USER_MANAGER(2), USER(3);

        private final int value;

        Tipo(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
}

