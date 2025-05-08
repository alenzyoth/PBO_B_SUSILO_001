// Kelas Admin
class Admin {
    private final String username = "Admin001";
    private final String password = "password001";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}
