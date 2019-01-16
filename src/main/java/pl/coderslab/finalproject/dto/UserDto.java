//package pl.coderslab.finalproject.dto;
//
//
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.NaturalIdCache;
//import org.mindrot.jbcrypt.BCrypt;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import static javax.persistence.CascadeType.ALL;
//
//
//
//public class User {
//
//    private Long id;
//
//    private LocalDateTime createDateTime;
//    private String firstName;
//
//    private String lastName;
//    @NotBlank
//    @NotEmpty
//    private String email;
//    @NotEmpty
//    @Size(min = 2, max = 30, message = "hasło musi posiadac od 2 do 30 znaków")
//    private String password;
//
//    private UserDetailDto userDetailsDto;
//
//    private String administrativeRights;
//
//    private boolean confirmationStatus;
//    private String confirmationId;
//
//    private String confirmationOnlineId;
//    private boolean online;
//
//
//}
