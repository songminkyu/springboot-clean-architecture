package example.project.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Identity identity;
    private String userName;
    private String password;
    private String address;
    private boolean admin;

    public static User create(String userName, String password, String address, boolean admin) {
        return new User(
                Identity.NONE,
                userName,
                password,
                address,
                admin
        );
    }
}
