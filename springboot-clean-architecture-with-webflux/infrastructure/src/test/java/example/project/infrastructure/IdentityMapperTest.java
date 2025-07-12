package example.project.infrastructure;

import example.project.entity.Identity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentityMapperTest {

    @Test
    public void createdIdentityShouldReturnSameValue(){
        Long value = 1L;
        Identity identity = Identity.of(value);
        Long mappedValue = IdentityMapper.map(identity);
        assertThat(value).isEqualTo(mappedValue);
    }

    @Test
    public void noneIdentityShouldReturnNull(){
        Identity identity = Identity.NONE;
        Long actualId = IdentityMapper.map(identity);

        assertThat(actualId).isNull();
    }

}
