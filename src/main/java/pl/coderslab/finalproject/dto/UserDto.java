package pl.coderslab.finalproject.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;



public class UserDto {

    private Long id;

    private LocalDateTime createDateTime;
    private String firstName;

    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 2, max = 30, message = "hasło musi posiadac od 2 do 30 znaków")
    private String password;

    private UserDetailDto userDetailsDto;

    private String administrativeRights;

    private boolean confirmationStatus;
    private String confirmationId;

    private String confirmationOnlineId;
    private boolean online;


    public UserDto() {
    }

    public UserDto(Long id, LocalDateTime createDateTime, String firstName, String lastName, @NotBlank String email, @NotBlank @Size(min = 2, max = 30, message = "hasło musi posiadac od 2 do 30 znaków") String password, UserDetailDto userDetailsDto, String administrativeRights, boolean confirmationStatus, String confirmationId, String confirmationOnlineId, boolean online) {
        this.id = id;
        this.createDateTime = createDateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userDetailsDto = userDetailsDto;
        this.administrativeRights = administrativeRights;
        this.confirmationStatus = confirmationStatus;
        this.confirmationId = confirmationId;
        this.confirmationOnlineId = confirmationOnlineId;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetailDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public String getAdministrativeRights() {
        return administrativeRights;
    }

    public void setAdministrativeRights(String administrativeRights) {
        this.administrativeRights = administrativeRights;
    }

    public boolean isConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getConfirmationOnlineId() {
        return confirmationOnlineId;
    }

    public void setConfirmationOnlineId(String confirmationOnlineId) {
        this.confirmationOnlineId = confirmationOnlineId;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
