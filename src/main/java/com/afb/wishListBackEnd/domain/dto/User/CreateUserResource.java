package com.afb.wishListBackEnd.domain.dto.User;

import com.afb.wishListBackEnd.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResource {
    private Long id;

    private String username;

    private String password;

    private LocalDateTime dateCreated;

    private Boolean active;

    public CreateUserResource(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.dateCreated = user.getDateCreated();
        this.active = user.getActive();
    }

    public User convert(){
        return new User(username,password,dateCreated,active);
    }
}
