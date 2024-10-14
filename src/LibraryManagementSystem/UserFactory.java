package LibraryManagementSystem;

class UserFactory {
    public static User createUser(UserType userType, String name, String userId) {
        switch (userType) {
            case MEMBER:
                return new Member(name, userId);
            case LIBRARIAN:
                return new Librarian(name, userId);
            default:
                throw new IllegalArgumentException("Unknown user type.");
        }
    }
}