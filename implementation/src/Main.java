public class Main {
    public static void main(String[] args) {
            IDsAndPasswords IDandPassword = new IDsAndPasswords();

            loginPage loginPage = new loginPage(IDandPassword.getLoginInfo());
        }
}