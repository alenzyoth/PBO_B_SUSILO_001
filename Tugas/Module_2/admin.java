class admin {
        private final String username = "Admin005";
        private final String password = "password005";

        public boolean login(String inputUsername, String inputPassword) {
            return inputUsername.equals(username) && inputPassword.equals(password);
        }
}
