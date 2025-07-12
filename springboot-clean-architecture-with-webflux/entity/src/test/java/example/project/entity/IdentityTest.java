package example.project.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentityTest {

    @Test
    public void createNewInstance(){
        Long id = 100L;
        Identity identity = Identity.of(id);
        Long resultId = identity.getId();
        assertThat(resultId).isEqualTo(id);
    }

    @Test
    public void checkNoneEqualsInfinite(){
        Long value = Long.MIN_VALUE;
        Identity identity = Identity.NONE;
        assertThat(identity.getId()).isEqualTo(value);
    }
}
