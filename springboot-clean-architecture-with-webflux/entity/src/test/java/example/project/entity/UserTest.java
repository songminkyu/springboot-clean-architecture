package example.project.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void createNewInstance(){
        String userName = "username";
        String password = "password";
        String address = "address";
        boolean admin = true;

        User user = User.create(userName, password, address, admin);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getAddress()).isEqualTo(address);
        assertThat(user.isAdmin()).isEqualTo(admin);
    }
    @Test
    public void createInstanceWithFullField(){
        Identity identity = Identity.of(100L);
        String userName = "username";
        String password = "password";
        String address = "address";
        boolean admin = true;

        User user = new User(identity, userName, password, address, admin);
        assertThat(user.getIdentity()).isEqualTo(identity);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getAddress()).isEqualTo(address);
        assertThat(user.isAdmin()).isEqualTo(admin);
    }

    @Test
    public void checkSetterWorks(){
        Identity identity = Identity.of(100L);
        String userName = "username";
        String password = "password";
        String address = "address";
        boolean admin = true;

        User user = new User(identity, userName, password, address, admin);
        user.setIdentity(identity);
        user.setUserName(userName);
        user.setPassword(password);
        user.setAddress(address);
        user.setAdmin(admin);

        assertThat(user.getIdentity()).isEqualTo(identity);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getAddress()).isEqualTo(address);
        assertThat(user.isAdmin()).isEqualTo(admin);
    }
}
