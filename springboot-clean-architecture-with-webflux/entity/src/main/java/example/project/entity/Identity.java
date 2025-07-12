package example.project.entity;

import lombok.Value;

@Value
public class Identity {
    public static Identity of(Long id){
        return new Identity(id);
    }
    public static Identity NONE = new Identity(Long.MIN_VALUE);
    Long id;
    public Long getId(){
        return this.id;
    }
    private Identity(Long id){
        this.id = id;
    }
}
