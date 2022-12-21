package com.afb.wishListBackEnd.domain.dto.User;

import com.afb.wishListBackEnd.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResource {
    private Long id;

    private String username;

    private String profilePicture;

    private LocalDateTime dateCreated;

    private Boolean active;

    public GetUserResource(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.profilePicture = user.getProfilePicture();
        this.dateCreated = user.getDateCreated();
        this.active = user.getActive();
    }

    public static List<GetUserResource> convert(List<User> userList){
        return userList.stream().map(GetUserResource::new).collect(Collectors.toList());
    }

}
